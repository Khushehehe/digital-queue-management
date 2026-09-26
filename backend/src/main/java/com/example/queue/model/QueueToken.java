package com.example.queue.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name="queue_tokens")
public class QueueToken {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    private String tokenNumber;
    @Enumerated(EnumType.STRING) private TokenPriority priority;
    @Enumerated(EnumType.STRING) private TokenStatus status;
    private Long userId; private Long serviceId; private Long counterId;
    private LocalDateTime createdAt, calledAt, completedAt;
    public QueueToken(){}
    public Long getId(){return id;} public String getTokenNumber(){return tokenNumber;}
    public TokenPriority getPriority(){return priority;} public TokenStatus getStatus(){return status;}
    public Long getUserId(){return userId;} public Long getServiceId(){return serviceId;} public Long getCounterId(){return counterId;}
    public LocalDateTime getCreatedAt(){return createdAt;} public LocalDateTime getCalledAt(){return calledAt;} public LocalDateTime getCompletedAt(){return completedAt;}
    public void setTokenNumber(String x){tokenNumber=x;} public void setPriority(TokenPriority x){priority=x;} public void setStatus(TokenStatus x){status=x;}
    public void setUserId(Long x){userId=x;} public void setServiceId(Long x){serviceId=x;} public void setCounterId(Long x){counterId=x;}
    public void setCreatedAt(LocalDateTime x){createdAt=x;} public void setCalledAt(LocalDateTime x){calledAt=x;} public void setCompletedAt(LocalDateTime x){completedAt=x;}
}
