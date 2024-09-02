package com.upao.tutoring_academic_support_api.controller;

import com.upao.tutoring_academic_support_api.domain.Tutor;
import com.upao.tutoring_academic_support_api.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tutors")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @GetMapping
    public List<Tutor> getAllTutors() {
        return tutorService.getAllTutors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> getTutorById(@PathVariable Long id) {
        Optional<Tutor> tutor = tutorService.getTutorById(id);
        return tutor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tutor createTutor(@RequestBody Tutor tutor) {
        return tutorService.createTutor(tutor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTutor(@PathVariable Long id) {
        tutorService.deleteTutor(id);
        return ResponseEntity.noContent().build();
    }
}

