package com.example.queue.service;
import com.example.queue.model.*; import com.example.queue.repo.*; import org.springframework.stereotype.Service;
import java.time.LocalDateTime; import java.util.*;
@Service
public class QueueService {
    private final TokenRepository tokens; private final ServiceRepository services; private final CounterRepository counters;
    public QueueService(TokenRepository t,ServiceRepository s,CounterRepository c){tokens=t;services=s;counters=c;}
    public QueueToken create(Long userId,Long serviceId,TokenPriority priority){
        var svc=services.findById(serviceId).orElseThrow();
        long normalCount=tokens.countByServiceIdAndStatus(serviceId,TokenStatus.WAITING);
        String prefix=priority==TokenPriority.PRIORITY?"P":"N";
        QueueToken t=new QueueToken(); t.setTokenNumber(prefix+(normalCount+1)); t.setPriority(priority); t.setStatus(TokenStatus.WAITING);
        t.setUserId(userId); t.setServiceId(serviceId); t.setCreatedAt(LocalDateTime.now()); return tokens.save(t);
    }
    public List<QueueToken> waiting(Long serviceId){
        var list=tokens.findByServiceIdAndStatus(serviceId,TokenStatus.WAITING);
        list.sort(Comparator.comparing(QueueToken::getPriority).reversed().thenComparing(QueueToken::getCreatedAt));
        return list;
    }
    public QueueToken next(Long serviceId,Long counterId){
        var q=waiting(serviceId); if(q.isEmpty()) throw new IllegalStateException("No waiting tokens");
        QueueToken t=q.get(0); t.setStatus(TokenStatus.SERVING); t.setCounterId(counterId); t.setCalledAt(LocalDateTime.now()); return tokens.save(t);
    }
    public QueueToken finish(Long id,TokenStatus status){
        QueueToken t=tokens.findById(id).orElseThrow(); t.setStatus(status); t.setCompletedAt(LocalDateTime.now()); return tokens.save(t);
    }
    public long estimate(Long serviceId){
        long ahead=tokens.countByServiceIdAndStatus(serviceId,TokenStatus.WAITING);
        int avg=services.findById(serviceId).orElseThrow().getAverageMinutes();
        int active=(int)counters.findByActiveTrue().stream().filter(c->serviceId.equals(c.getServiceId())).count();
        return active==0?ahead*avg:Math.max(1,(ahead*avg)/active);
    }
}
