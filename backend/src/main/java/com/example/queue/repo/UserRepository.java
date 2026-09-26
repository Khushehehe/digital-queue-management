package com.example.queue.repo;
import com.example.queue.model.AppUser; import java.util.Optional; import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<AppUser,Long>{ Optional<AppUser> findByEmail(String email); }
