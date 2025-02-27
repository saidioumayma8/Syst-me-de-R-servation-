package com.Model;

public class Patient {

    private String Username;
    private String Email;
    private String Telephone;


    public Patient(String name, String email, String telephone) {
        this.Username = name;
        this.Email = email;
        this.Telephone = telephone;
    }

    public Patient(String username, Object email, String password, Object o, Object o1) {
    }

    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        this.Username = username;
    }


    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        this.Email = email;
    }


    public String getTelephone() {
        return Telephone;
    }
    public void setTelephone(String telephone) {
        this.Telephone = telephone;
    }

    public boolean validateLogin() {
        // Example: Logic for validation can be added here
        return false; // Temporary return value
    }

    public boolean register() {
        // Example: Logic for registration can be added here
        return false; // Temporary return value
    }

}
