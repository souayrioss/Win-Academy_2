package org.example.entity;

import javax.management.relation.Role;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;


import static org.example.entity.Admins.*;
import static org.example.entity.Enseignants.*;
import static org.example.entity.Etudiants.*;


abstract public class Users implements Serializable {
    private static final AtomicInteger count = new AtomicInteger(0);
    protected  int id_user;
    protected UUID uuid;
    protected String fullName;
    protected String email;
    protected String password;
    protected String tel;

    protected int role_id;

    public Users() {
    }

    public Users(String fullName, String email, String password, String tel) {
        this.id_user = count.incrementAndGet();
        this.uuid = UUID.randomUUID();
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.tel = tel;
    }
    public int getId_user() {
        return id_user;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }


}
