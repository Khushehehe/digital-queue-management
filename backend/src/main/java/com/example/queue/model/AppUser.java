package com.example.queue.model;
import jakarta.persistence.*;
@Entity
@Table(name="users")
public class AppUser {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(unique=true, nullable=false) private String email;
    @Column(nullable=false) private String password;
    @Enumerated(EnumType.STRING) @Column(nullable=false) private Role role;
    private String name;
    public AppUser() {}
    public AppUser(String name,String email,String password,Role role){this.name=name;this.email=email;this.password=password;this.role=role;}
    public Long getId(){return id;} public String getEmail(){return email;} public String getPassword(){return password;}
    public Role getRole(){return role;} public String getName(){return name;}
}
