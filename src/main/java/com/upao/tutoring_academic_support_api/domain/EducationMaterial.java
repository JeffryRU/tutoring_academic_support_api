package com.upao.tutoring_academic_support_api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class EducationMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String url;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private User tutor;

    public EducationMaterial() { // Cambiado a "EducationMaterial" para coincidir con el nombre de la clase
    }

    public EducationMaterial(String nombre, String url, User tutor) { // Cambiado a "EducationMaterial"
        this.nombre = nombre;
        this.url = url;
        this.tutor = tutor;
    }

}
