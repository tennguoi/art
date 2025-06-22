package com.example.demo.controller;

import com.example.demo.model.GiaoDich;
import com.example.demo.service.GiaoDichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/giao-dich")
public class GiaoDichController {
    @Autowired
    private GiaoDichService giaoDichService;

    @GetMapping
    public List<GiaoDich> getAll() {
        return giaoDichService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GiaoDich> getById(@PathVariable Integer id) {
        return giaoDichService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public GiaoDich create(@RequestBody GiaoDich giaoDich) {
        return giaoDichService.save(giaoDich);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GiaoDich> update(@PathVariable Integer id, @RequestBody GiaoDich giaoDich) {
        return giaoDichService.findById(id)
                .map(existing -> {
                    giaoDich.setId(id);
                    return ResponseEntity.ok(giaoDichService.save(giaoDich));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (giaoDichService.findById(id).isPresent()) {
            giaoDichService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
} 