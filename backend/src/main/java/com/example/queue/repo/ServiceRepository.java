package com.example.queue.repo;
import com.example.queue.model.GovernmentService; import org.springframework.data.jpa.repository.JpaRepository;
public interface ServiceRepository extends JpaRepository<GovernmentService,Long>{}
