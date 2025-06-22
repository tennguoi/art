package com.example.demo.service.impl;

import com.example.demo.model.Tranh;
import com.example.demo.repository.TranhRepository;
import com.example.demo.service.TranhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TranhServiceImpl implements TranhService {
    @Autowired
    private TranhRepository tranhRepository;

    @Override
    public List<Tranh> findAll() {
        return tranhRepository.findAll();
    }

    @Override
    public Optional<Tranh> findById(Integer id) {
        return tranhRepository.findById(id);
    }

    @Override
    public Tranh save(Tranh tranh) {
        return tranhRepository.save(tranh);
    }

    @Override
    public void deleteById(Integer id) {
        tranhRepository.deleteById(id);
    }
} 