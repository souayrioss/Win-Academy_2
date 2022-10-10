package org.example.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Roles implements Serializable {
    private  int id_role ;
    private String role;

    public Roles(int id_role,String role) {
        this.id_role = id_role;
        this.role = role;
    }

    public int getId_role() {
        return id_role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}

