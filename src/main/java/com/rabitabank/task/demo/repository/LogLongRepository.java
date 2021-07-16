package com.rabitabank.task.demo.repository;

import com.rabitabank.task.demo.model.LogLong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogLongRepository extends JpaRepository<LogLong, Integer> {
    
}
