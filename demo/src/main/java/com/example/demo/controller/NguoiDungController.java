package com.example.demo.controller;

import com.example.demo.model.NguoiDung;
import com.example.demo.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nguoi-dung")
public class NguoiDungController {
    @Autowired
    private NguoiDungService nguoiDungService;

    @GetMapping
    public List<NguoiDung> getAll() {
        return nguoiDungService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NguoiDung> getById(@PathVariable Integer id) {
        return nguoiDungService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public NguoiDung create(@RequestBody NguoiDung nguoiDung) {
        return nguoiDungService.save(nguoiDung);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NguoiDung> update(@PathVariable Integer id, @RequestBody NguoiDung nguoiDung) {
        return nguoiDungService.findById(id)
                .map(existing -> {
                    nguoiDung.setId(id);
                    return ResponseEntity.ok(nguoiDungService.save(nguoiDung));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (nguoiDungService.findById(id).isPresent()) {
            nguoiDungService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
} 