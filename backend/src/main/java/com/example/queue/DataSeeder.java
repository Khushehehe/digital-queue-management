package com.example.queue;
import com.example.queue.model.*; import com.example.queue.repo.*; import org.springframework.boot.CommandLineRunner; import org.springframework.context.annotation.Bean; import org.springframework.context.annotation.Configuration; import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
public class DataSeeder {
 @Bean CommandLineRunner seed(UserRepository users,ServiceRepository services,CounterRepository counters,PasswordEncoder enc){
  return args -> {
   if(users.count()==0){
    users.save(new AppUser("Citizen","citizen@test.com",enc.encode("1234"),Role.CITIZEN));
    users.save(new AppUser("Staff","staff@test.com",enc.encode("1234"),Role.STAFF));
    users.save(new AppUser("Admin","admin@test.com",enc.encode("1234"),Role.ADMIN));
   }
   if(services.count()==0){
    var s1=services.save(new GovernmentService("Passport Application","New passport and renewal",15));
    var s2=services.save(new GovernmentService("Certificate Service","Birth/income/residence certificates",10));
    counters.save(new Counter(1,s1.getId())); counters.save(new Counter(2,s1.getId())); counters.save(new Counter(3,s2.getId()));
   }
  };
 }
}
