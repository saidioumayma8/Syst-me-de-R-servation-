package com.Model;

public class Patient extends User {
    private String phone;

    public Patient(int userId, String name, String password, String phone, Role patient, String email) {
        super(userId, name, email, password, patient);  // 🔹 Pass userId to parent
        this.phone = phone;
    }

    public Patient(String name, String password, String phone, Role patient, String email) {
        super(name, email, password, patient);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
