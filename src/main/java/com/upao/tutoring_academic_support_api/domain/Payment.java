package com.upao.tutoring_academic_support_api.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private LocalDateTime date;
    private String method;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // Constructores, getters y setters

    public Payment() {}

    public Payment(double amount, LocalDateTime date, String method, Student student) {
        this.amount = amount;
        this.date = date;
        this.method = method;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

