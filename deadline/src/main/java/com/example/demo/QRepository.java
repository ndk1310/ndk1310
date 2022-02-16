package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QRepository extends JpaRepository<StackEntity, Long>{

        @Query(value = "SELECT id, Question FROM StackEntity")
        List<Stackmini> findAllProjectsMini();}
