package com.example.queue.model;
import jakarta.persistence.*;
@Entity
public class Counter {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    private int counterNumber; private boolean active=true; private Long serviceId;
    public Counter() {}
    public Counter(int n,Long serviceId){counterNumber=n;this.serviceId=serviceId;}
    public Long getId(){return id;} public int getCounterNumber(){return counterNumber;} public boolean isActive(){return active;}
    public Long getServiceId(){return serviceId;} public void setActive(boolean a){active=a;} public void setServiceId(Long s){serviceId=s;}
}
