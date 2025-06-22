package com.example.demo.repository;

import com.example.demo.model.Tranh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranhRepository extends JpaRepository<Tranh, Integer> {
} 