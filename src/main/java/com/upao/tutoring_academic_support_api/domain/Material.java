package com.upao.tutoring_academic_support_api.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "materials")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;  // Puede ser 'documento', 'video', etc.
    private String url;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    // Constructores, getters y setters

    public Material() {}

    public Material(String type, String url, Tutor tutor) {
        this.type = type;
        this.url = url;
        this.tutor = tutor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}
