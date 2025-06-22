package com.example.demo.service;

import com.example.demo.model.KhachHang;
import java.util.List;
import java.util.Optional;

public interface KhachHangService {
    List<KhachHang> findAll();
    Optional<KhachHang> findById(Integer id);
    KhachHang save(KhachHang khachHang);
    void deleteById(Integer id);
} 