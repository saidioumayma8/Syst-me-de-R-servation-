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


    public String getName() {
        return Username;
    }
    public void setName(String name) {
        this.Username = name;
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

}
