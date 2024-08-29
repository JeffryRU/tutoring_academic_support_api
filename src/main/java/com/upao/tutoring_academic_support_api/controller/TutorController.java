package com.upao.tutoring_academic_support_api.controller;

import com.upao.tutoring_academic_support_api.domain.Tutor;
import com.upao.tutoring_academic_support_api.domain.Session;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tutores")
public class TutorController {

    private List<Tutor> tutores = new ArrayList<>(); // Lista simulada

    @GetMapping
    public List<Tutor> getAllTutores() {
        return tutores;
    }

    @GetMapping("/{id}")
    public Tutor getTutorById(@PathVariable Long id) {
        return tutores.stream()
                .filter(tutor -> tutor.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Tutor createTutor(@RequestBody Tutor tutor) {
        tutores.add(tutor);
        return tutor;
    }

    @PutMapping("/{id}")
    public Tutor updateTutor(@PathVariable Long id, @RequestBody Tutor tutorDetalles) {
        Tutor tutor = getTutorById(id);
        if (tutor != null) {
            tutor.setNombre(tutorDetalles.getNombre());
            tutor.setEspecialidad(tutorDetalles.getEspecialidad());
            tutor.setTarifa(tutorDetalles.getTarifa());
        }
        return tutor;
    }

    @DeleteMapping("/{id}")
    public String deleteTutor(@PathVariable Long id) {
        Tutor tutor = getTutorById(id);
        if (tutor != null) {
            tutores.remove(tutor);
            return "Tutor eliminado";
        }
        return "Tutor no encontrado";
    }

    // Reservar sesión
    @PostMapping("/{id}/reservar")
    public String reservarSesion(@PathVariable Long id, @RequestBody Session session) {
        Tutor tutor = getTutorById(id);
        if (tutor != null) {
            tutor.getSesiones().add(session);
            return "Sesión reservada con éxito";
        }
        return "Tutor no encontrado";
    }
}
