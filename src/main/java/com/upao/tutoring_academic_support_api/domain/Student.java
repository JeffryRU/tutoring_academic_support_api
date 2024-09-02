package com.upao.tutoring_academic_support_api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends User {

    private String interests;
    private String learningPreferences;

    // Constructores, getters y setters

    public Student() {}

    public Student(String username, String password, String email, String interests, String learningPreferences) {
        super(username, password, email);
        this.interests = interests;
        this.learningPreferences = learningPreferences;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getLearningPreferences() {
        return learningPreferences;
    }

    public void setLearningPreferences(String learningPreferences) {
        this.learningPreferences = learningPreferences;
    }
}

