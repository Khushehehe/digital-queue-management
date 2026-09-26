package com.example.queue.controller;
import com.example.queue.repo.ServiceRepository; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/services")
public class ServiceController { private final ServiceRepository repo; public ServiceController(ServiceRepository r){repo=r;}
@GetMapping public Object all(){return repo.findAll();}}
