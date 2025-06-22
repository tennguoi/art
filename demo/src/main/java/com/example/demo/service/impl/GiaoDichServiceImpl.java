package com.example.demo.service.impl;

import com.example.demo.model.GiaoDich;
import com.example.demo.repository.GiaoDichRepository;
import com.example.demo.service.GiaoDichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GiaoDichServiceImpl implements GiaoDichService {
    @Autowired
    private GiaoDichRepository giaoDichRepository;

    @Override
    public List<GiaoDich> findAll() {
        return giaoDichRepository.findAll();
    }

    @Override
    public Optional<GiaoDich> findById(Integer id) {
        return giaoDichRepository.findById(id);
    }

    @Override
    public GiaoDich save(GiaoDich giaoDich) {
        return giaoDichRepository.save(giaoDich);
    }

    @Override
    public void deleteById(Integer id) {
        giaoDichRepository.deleteById(id);
    }
} 