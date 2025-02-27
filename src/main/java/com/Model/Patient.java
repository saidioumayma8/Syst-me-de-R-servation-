package com.Model;

public class Patient extends User {
    private String phone;
    private String email;

    public Patient(String name, String password, String phone, String email, Object o) {
        super(name, password);  // Call the parent constructor
        this.phone = phone;
        this.email = email;
    }

    // Getters and Setters
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean validateLogin() {
        return false;
    }
}
