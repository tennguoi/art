package com.example.demo.controller;

import com.example.demo.model.Tranh;
import com.example.demo.service.TranhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tranh")
public class TranhController {
    @Autowired
    private TranhService tranhService;

    @GetMapping
    public List<Tranh> getAll() {
        return tranhService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tranh> getById(@PathVariable Integer id) {
        return tranhService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tranh create(@RequestBody Tranh tranh) {
        return tranhService.save(tranh);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tranh> update(@PathVariable Integer id, @RequestBody Tranh tranh) {
        return tranhService.findById(id)
                .map(existing -> {
                    tranh.setId(id);
                    return ResponseEntity.ok(tranhService.save(tranh));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (tranhService.findById(id).isPresent()) {
            tranhService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
} 