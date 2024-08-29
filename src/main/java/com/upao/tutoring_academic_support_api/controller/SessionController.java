package com.upao.tutoring_academic_support_api.controller;

import com.upao.tutoring_academic_support_api.domain.Session;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/sesiones")
public class SessionController {

    private List<Session> sesiones = new ArrayList<>(); // Lista simulada

    @GetMapping
    public List<Session> getAllSession() {
        return sesiones;
    }

    @GetMapping("/{id}")
    public Session getSessionById(@PathVariable Long id) {
        return sesiones.stream()
                .filter(sesion -> sesion.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Session createSession(@RequestBody Session sesion) {
        sesiones.add(sesion);
        return sesion;
    }

    @PutMapping("/{id}")
    public Session updateSession(@PathVariable Long id, @RequestBody Session sesionDetalles) {
        Session sesion = getSessionById(id);
        if (sesion != null) {
            sesion.setFecha(sesionDetalles.getFecha());
            sesion.setMateria(sesionDetalles.getMateria());
        }
        return sesion;
    }

    @DeleteMapping("/{id}")
    public String deleteSesion(@PathVariable Long id) {
        Session sesion = getSessionById(id);
        if (sesion != null) {
            sesiones.remove(sesion);
            return "Sesión eliminada";
        }
        return "Sesión no encontrada";
    }

    // Subida de materiales educativos
    @PostMapping("/{id}/materiales")
    public String uploadMaterial(@PathVariable Long id, @RequestBody String material) {
        Session session = getSessionById(id);
        if (session != null) {
            // Concatenar el nuevo material a la propiedad materia
            if (session.getMateria() == null || session.getMateria().isEmpty()) {
                session.setMateria(material);
            } else {
                session.setMateria(session.getMateria() + ", " + material);
            }
            return "Material subido con éxito";
        }
        return "Sesión no encontrada";
    }
}
