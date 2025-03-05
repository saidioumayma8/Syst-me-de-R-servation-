package com.Model;

public class Patient extends User {
    private String phone;

    public Patient(int userId, String name, String email, String password, Role patient, String phone) {
        super(userId, name, email, password, patient);
        this.phone = phone;
    }

    public Patient(String name, String email, String password, Role patient, String phone) {
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
