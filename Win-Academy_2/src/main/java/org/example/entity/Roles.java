package com.win_academy;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Roles {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id_role ;
    private String role;
    private ArrayList<Users> users ;

    public Roles(String role) {
        this.id_role = count.incrementAndGet();
        this.role = role;
        this.users = new ArrayList<Users>();
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

    public ArrayList<Users> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Users> user) {
        this.users = user;
    }
}

