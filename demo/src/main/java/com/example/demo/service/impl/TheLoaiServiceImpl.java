package com.example.demo.service.impl;

import com.example.demo.model.TheLoai;
import com.example.demo.repository.TheLoaiRepository;
import com.example.demo.service.TheLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheLoaiServiceImpl implements TheLoaiService {
    @Autowired
    private TheLoaiRepository theLoaiRepository;

    @Override
    public List<TheLoai> findAll() {
        return theLoaiRepository.findAll();
    }

    @Override
    public Optional<TheLoai> findById(Integer id) {
        return theLoaiRepository.findById(id);
    }

    @Override
    public TheLoai save(TheLoai theLoai) {
        return theLoaiRepository.save(theLoai);
    }

    @Override
    public void deleteById(Integer id) {
        theLoaiRepository.deleteById(id);
    }
} 