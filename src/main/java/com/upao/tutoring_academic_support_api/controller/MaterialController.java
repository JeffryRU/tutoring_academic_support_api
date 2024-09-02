package com.upao.tutoring_academic_support_api.controller;

import com.upao.tutoring_academic_support_api.domain.Material;
import com.upao.tutoring_academic_support_api.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/materials")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping
    public List<Material> getAllMaterials() {
        return materialService.getAllMaterials();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> getMaterialById(@PathVariable Long id) {
        Optional<Material> material = materialService.getMaterialById(id);
        return material.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Material createMaterial(@RequestBody Material material) {
        return materialService.createMaterial(material);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable Long id) {
        materialService.deleteMaterial(id);
        return ResponseEntity.noContent().build();
    }
}
