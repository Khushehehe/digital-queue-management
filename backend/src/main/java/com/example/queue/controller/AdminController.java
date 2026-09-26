package com.example.queue.controller;
import com.example.queue.repo.*; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/admin")
public class AdminController {
 private final TokenRepository tokens; private final CounterRepository counters; private final ServiceRepository services;
 public AdminController(TokenRepository t,CounterRepository c,ServiceRepository s){tokens=t;counters=c;services=s;}
 @GetMapping("/dashboard") public Object dashboard(){
   return Map.of("totalTokens",tokens.count(),"waitingTokens",tokens.countByServiceIdAndStatus(1L,com.example.queue.model.TokenStatus.WAITING),
     "counters",counters.findAll(),"services",services.findAll());
 }
 @PostMapping("/counter/{id}/toggle") public Object toggle(@PathVariable Long id){
   var c=counters.findById(id).orElseThrow(); c.setActive(!c.isActive()); return counters.save(c);
 }
}
