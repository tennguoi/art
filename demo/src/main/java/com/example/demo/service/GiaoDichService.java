package com.example.demo.service;

import com.example.demo.model.GiaoDich;
import java.util.List;
import java.util.Optional;

public interface GiaoDichService {
    List<GiaoDich> findAll();
    Optional<GiaoDich> findById(Integer id);
    GiaoDich save(GiaoDich giaoDich);
    void deleteById(Integer id);
} 