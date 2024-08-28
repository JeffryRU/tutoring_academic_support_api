package domain.user_management_module;

import jakarta.persistence.Entity;

@Entity
public class Student extends User {
    private String academicInterests;
    private String learningPreferences;

    public Student() {}

    public Student(String name, String email, String password, String academicInterests, String learningPreferences) {
        super(name, email, password);
        this.academicInterests = academicInterests;
        this.learningPreferences = learningPreferences;
    }

    // Getters and setters
    public String getAcademicInterests() {
        return academicInterests;
    }

    public void setAcademicInterests(String academicInterests) {
        this.academicInterests = academicInterests;
    }

    public String getLearningPreferences() {
        return learningPreferences;
    }

    public void setLearningPreferences(String learningPreferences) {
        this.learningPreferences = learningPreferences;
    }
}
