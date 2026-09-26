package com.example.queue.repo;
import com.example.queue.model.*; import java.util.*; import org.springframework.data.jpa.repository.JpaRepository;
public interface TokenRepository extends JpaRepository<QueueToken,Long>{
 List<QueueToken> findByServiceIdAndStatus(Long serviceId, TokenStatus status);
 List<QueueToken> findByUserIdOrderByCreatedAtDesc(Long userId);
 long countByServiceIdAndStatus(Long serviceId, TokenStatus status);
}
