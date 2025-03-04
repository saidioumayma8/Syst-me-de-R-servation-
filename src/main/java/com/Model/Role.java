package com.Model;

public class Role {
    private int id;
    private String role_name;


    public Role(String role_name) {
        this.role_name = role_name;
    }

    public String getRoleName() {
        return role_name;
    }

    public void setRoleName(String role_name) {
        this.role_name = role_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
