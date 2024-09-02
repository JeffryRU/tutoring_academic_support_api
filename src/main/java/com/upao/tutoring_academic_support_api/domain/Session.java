package com.upao.tutoring_academic_support_api.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;
    private String type;  // Puede ser 'individual' o 'group'

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    // Constructores, getters y setters

    public Session() {}

    public Session(LocalDateTime date, String type, Tutor tutor) {
        this.date = date;
        this.type = type;
        this.tutor = tutor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}
