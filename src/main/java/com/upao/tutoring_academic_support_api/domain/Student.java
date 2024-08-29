package com.upao.tutoring_academic_support_api.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Student extends User {

    private String nivelEducativo;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Session> sesiones = new ArrayList<>();

    public Student() {
        super();
    }

    public Student(String nombre, String email, String contrasena, String nivelEducativo) {
        super(nombre, email, contrasena, Rol.ESTUDIANTE);
        this.nivelEducativo = nivelEducativo;
    }

    public String getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(String nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    public List<Session> getSesiones() {
        return sesiones;
    }

    public void setSesiones(List<Session> sesiones) {
        this.sesiones = sesiones;
    }
}
