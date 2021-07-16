package com.rabitabank.task.demo.repository;

import com.rabitabank.task.demo.model.LogShort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogShortRepository extends JpaRepository<LogShort, Integer> {

}
