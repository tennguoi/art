package com.example.demo.service;

import com.example.demo.model.NguoiDung;
import java.util.List;
import java.util.Optional;

public interface NguoiDungService {
    List<NguoiDung> findAll();
    Optional<NguoiDung> findById(Integer id);
    NguoiDung save(NguoiDung nguoiDung);
    void deleteById(Integer id);
} 