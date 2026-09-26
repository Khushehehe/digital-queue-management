package com.example.queue.controller;
import com.example.queue.model.*; import com.example.queue.repo.*; import com.example.queue.security.JwtService; import com.example.queue.service.QueueService;
import org.springframework.web.bind.annotation.*; import java.util.*; import org.springframework.http.*;
@RestController @RequestMapping("/api/queue")
public class QueueController {
    private final QueueService qs; private final TokenRepository tokens; private final JwtService jwt; private final CounterRepository counters;
    public QueueController(QueueService q,TokenRepository t,JwtService j,CounterRepository c){qs=q;tokens=t;jwt=j;counters=c;}
    @PostMapping("/token") public Object token(@RequestHeader("Authorization") String h,@RequestBody Map<String,Object> b){
        var c=jwt.parse(h.substring(7)); Long userId=((Number)c.get("id")).longValue(); Long serviceId=((Number)b.get("serviceId")).longValue();
        TokenPriority p=TokenPriority.valueOf(String.valueOf(b.get("priority"))); var t=qs.create(userId,serviceId,p);
        return Map.of("id",t.getId(),"tokenNumber",t.getTokenNumber(),"position",qs.waiting(serviceId).size(),"estimatedWait",qs.estimate(serviceId));
    }
    @GetMapping("/service/{serviceId}") public Object status(@PathVariable Long serviceId){
        var q=qs.waiting(serviceId); return Map.of("waiting",q.size(),"estimatedWait",qs.estimate(serviceId),"tokens",q);
    }
    @GetMapping("/my") public Object my(@RequestHeader("Authorization") String h){
        var c=jwt.parse(h.substring(7)); Long id=((Number)c.get("id")).longValue(); return tokens.findByUserIdOrderByCreatedAtDesc(id);
    }
    @PostMapping("/next") public Object next(@RequestBody Map<String,Long> b){return qs.next(b.get("serviceId"),b.get("counterId"));}
    @PostMapping("/{id}/complete") public Object complete(@PathVariable Long id){return qs.finish(id,TokenStatus.COMPLETED);}
    @PostMapping("/{id}/skip") public Object skip(@PathVariable Long id){return qs.finish(id,TokenStatus.SKIPPED);}
    @GetMapping("/counters") public Object counters(){return counters.findAll();}
}
