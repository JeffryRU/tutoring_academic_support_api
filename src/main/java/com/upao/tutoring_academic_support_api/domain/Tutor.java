package com.upao.tutoring_academic_support_api.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tutors")
public class Tutor extends User {

    private String specialization;
    private double hourlyRate;
    private String availability;

    // Constructores, getters y setters

    public Tutor() {}

    public Tutor(String username, String password, String email, String specialization, double hourlyRate, String availability) {
        super(username, password, email);
        this.specialization = specialization;
        this.hourlyRate = hourlyRate;
        this.availability = availability;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
