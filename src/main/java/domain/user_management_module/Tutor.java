package domain.user_management_module;

import jakarta.persistence.Entity;

@Entity
public class Tutor extends User {
    private String specialization;
    private String availability;
    private double ratePerHour;

    public Tutor() {}

    public Tutor(String name, String email, String password, String specialization, String availability, double ratePerHour) {
        super(name, email, password);
        this.specialization = specialization;
        this.availability = availability;
        this.ratePerHour = ratePerHour;
    }

    // Getters and setters
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }
}
