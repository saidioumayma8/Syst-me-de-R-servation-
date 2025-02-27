package com.Model;

public class Doctor extends User {
    private String specialty;

    public Doctor(String name, String password, String specialty) {
        super(name, password);  // Call the parent constructor
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
