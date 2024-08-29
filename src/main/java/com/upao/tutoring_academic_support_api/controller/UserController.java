package com.upao.tutoring_academic_support_api.controller;

import com.upao.tutoring_academic_support_api.domain.Student;
import com.upao.tutoring_academic_support_api.domain.Tutor;
import com.upao.tutoring_academic_support_api.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {

    private List<User> usuarios = new ArrayList<>(); // Lista simulada

    @GetMapping
    public List<User> getAllUsers() {
        return usuarios;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return usuarios.stream()
                .filter(usuario -> usuario.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public User createUser(@RequestBody User usuario) {
        usuarios.add(usuario);
        return usuario;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User usuarioDetalles) {
        User usuario = getUserById(id);
        if (usuario != null) {
            // Actualizar campos comunes
            usuario.setNombre(usuarioDetalles.getNombre());
            usuario.setEmail(usuarioDetalles.getEmail());
            usuario.setContrasena(usuarioDetalles.getContrasena());
            usuario.setRol(usuarioDetalles.getRol());

            // Actualizar atributos específicos según el rol
            if ("ESTUDIANTE".equals(usuarioDetalles.getRol()) && usuario instanceof Student) {
                Student estudiante = (Student) usuario;
                estudiante.setNivelEducativo(((Student) usuarioDetalles).getNivelEducativo());
            } else if ("TUTOR".equals(usuarioDetalles.getRol()) && usuario instanceof Tutor) {
                Tutor tutor = (Tutor) usuario;
                tutor.setEspecialidad(((Tutor) usuarioDetalles).getEspecialidad());
                tutor.setTarifa(((Tutor) usuarioDetalles).getTarifa());
            }
        }
        return usuario;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        User usuario = getUserById(id);
        if (usuario != null) {
            usuarios.remove(usuario);
            return "Usuario eliminado";
        }
        return "Usuario no encontrado";
    }

    @GetMapping("/tutores/{id}")
    public Tutor getTutorById(@PathVariable Long id) {
        return usuarios.stream()
                .filter(usuario -> usuario instanceof Tutor)
                .map(usuario -> (Tutor) usuario)
                .filter(tutor -> tutor.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/estudiantes/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return usuarios.stream()
                .filter(usuario -> usuario instanceof Student)
                .map(usuario -> (Student) usuario)
                .filter(estudiante -> estudiante.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
