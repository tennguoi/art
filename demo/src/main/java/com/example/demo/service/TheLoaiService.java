package com.example.demo.service;

import com.example.demo.model.TheLoai;
import java.util.List;
import java.util.Optional;

public interface TheLoaiService {
    List<TheLoai> findAll();
    Optional<TheLoai> findById(Integer id);
    TheLoai save(TheLoai theLoai);
    void deleteById(Integer id);
} 