package com.upao.tutoring_academic_support_api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private User tutor;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private User estudiante;

    public Report() {  // Cambio de "Reporte" a "Report" para coincidir con el nombre de la clase
    }

    public Report(String descripcion, LocalDateTime fecha, User tutor, User estudiante) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tutor = tutor;
        this.estudiante = estudiante;
    }

}
