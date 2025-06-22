package com.example.demo.service;

import com.example.demo.model.Tranh;
import java.util.List;
import java.util.Optional;

public interface TranhService {
    List<Tranh> findAll();
    Optional<Tranh> findById(Integer id);
    Tranh save(Tranh tranh);
    void deleteById(Integer id);
} 