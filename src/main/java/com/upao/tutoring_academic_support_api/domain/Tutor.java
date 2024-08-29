package com.upao.tutoring_academic_support_api.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Tutor extends User {

    private String especialidad;
    private Double tarifa;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Session> sesiones = new ArrayList<>();

    public Tutor() {
        super();
    }

    public Tutor(String nombre, String email, String contrasena, String especialidad, Double tarifa) {
        super(nombre, email, contrasena, Rol.TUTOR);
        this.especialidad = especialidad;
        this.tarifa = tarifa;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Double getTarifa() {
        return tarifa;
    }

    public void setTarifa(Double tarifa) {
        this.tarifa = tarifa;
    }

    public List<Session> getSesiones() {
        return sesiones;
    }

    public void setSesiones(List<Session> sesiones) {
        this.sesiones = sesiones;
    }
}
