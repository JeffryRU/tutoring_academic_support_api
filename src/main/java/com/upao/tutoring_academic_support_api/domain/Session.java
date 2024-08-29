package com.upao.tutoring_academic_support_api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha;
    private String materia;
    private String estado; // "PENDIENTE", "COMPLETADA", "CANCELADA"

    @ManyToOne
    @JoinColumn(name = "tutor_id") // Se asegura de que el nombre de la columna es correcto
    private User tutor;

    @ManyToOne
    @JoinColumn(name = "estudiante_id") // Se asegura de que el nombre de la columna es correcto
    private User estudiante;

    public Session() {
    }

    public Session(LocalDateTime fecha, String materia, String estado, User tutor, User estudiante) {
        this.fecha = fecha;
        this.materia = materia;
        this.estado = estado;
        this.tutor = tutor;
        this.estudiante = estudiante;
    }

}
