package com.example.demo.controller;

import com.example.demo.model.TheLoai;
import com.example.demo.service.TheLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/the-loai")
public class TheLoaiController {
    @Autowired
    private TheLoaiService theLoaiService;

    @GetMapping
    public List<TheLoai> getAll() {
        return theLoaiService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TheLoai> getById(@PathVariable Integer id) {
        return theLoaiService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TheLoai create(@RequestBody TheLoai theLoai) {
        return theLoaiService.save(theLoai);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TheLoai> update(@PathVariable Integer id, @RequestBody TheLoai theLoai) {
        return theLoaiService.findById(id)
                .map(existing -> {
                    theLoai.setId(id);
                    return ResponseEntity.ok(theLoaiService.save(theLoai));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (theLoaiService.findById(id).isPresent()) {
            theLoaiService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
} 