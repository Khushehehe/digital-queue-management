package com.example.queue.repo;
import com.example.queue.model.Counter; import java.util.List; import org.springframework.data.jpa.repository.JpaRepository;
public interface CounterRepository extends JpaRepository<Counter,Long>{ List<Counter> findByActiveTrue(); }
