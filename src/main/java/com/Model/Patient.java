package com.Model;

public class Patient extends User {
    private String phone;
    private String email;

    public Patient(String name, String password, String phone, String email) {
        super(name, password);
        this.phone = phone;
        this.email = email;
    }


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


}
