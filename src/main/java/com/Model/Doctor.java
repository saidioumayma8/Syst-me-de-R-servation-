package com.Model;

public class Doctor extends User {
    private String specialty;

    public Doctor(String name, String email, String password, Role role, String specialty) {
        super(name, email, password, role);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
