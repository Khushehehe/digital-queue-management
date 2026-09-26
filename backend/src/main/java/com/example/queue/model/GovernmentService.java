package com.example.queue.model;
import jakarta.persistence.*;
@Entity
public class GovernmentService {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    private String name; private String description; private int averageMinutes;
    public GovernmentService() {}
    public GovernmentService(String name,String description,int averageMinutes){this.name=name;this.description=description;this.averageMinutes=averageMinutes;}
    public Long getId(){return id;} public String getName(){return name;} public String getDescription(){return description;}
    public int getAverageMinutes(){return averageMinutes;}
}
