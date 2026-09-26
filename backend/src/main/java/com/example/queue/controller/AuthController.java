package com.example.queue.controller;
import com.example.queue.model.*; import com.example.queue.repo.UserRepository; import com.example.queue.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/auth")
public class AuthController {
    private final UserRepository users; private final PasswordEncoder encoder; private final JwtService jwt;
    public AuthController(UserRepository u,PasswordEncoder e,JwtService j){users=u;encoder=e;jwt=j;}
    @PostMapping("/login") public Map<String,Object> login(@RequestBody Map<String,String> body){
        var u=users.findByEmail(body.get("email")).orElseThrow(()->new RuntimeException("Invalid credentials"));
        if(!encoder.matches(body.get("password"),u.getPassword())) throw new RuntimeException("Invalid credentials");
        return Map.of("token",jwt.generate(u.getEmail(),u.getRole().name(),u.getId()),"role",u.getRole().name(),"name",u.getName(),"userId",u.getId());
    }
}
