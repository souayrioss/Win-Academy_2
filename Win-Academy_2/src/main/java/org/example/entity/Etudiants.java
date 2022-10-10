package org.example.entity;

import java.io.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Etudiants extends Users implements Serializable {
    private String code ;
    private String annee_scolaire;
    private int group_id;
    private int college_id;
    public Etudiants() {
    }

    public Etudiants(String fullName, String email, String password, String tel, String code, String annee_scolaire) {
        super(fullName, email, password, tel);
        this.code = code;
        this.annee_scolaire = annee_scolaire;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAnnee_scolaire() {
        return annee_scolaire;
    }

    public void setAnnee_scolaire(String annee_scolaire) {
        this.annee_scolaire = annee_scolaire;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public int getCollege_id() {
        return college_id;
    }

    public void setCollege_id(int college_id) {
        this.college_id = college_id;
    }

    @Override
    public String toString() {
        return "\nEtudiants{" +
                "code='" + code + '\'' +
                ", annee_scolaire='" + annee_scolaire + '\'' +
                ", group_id=" + group_id +
                ", id_college=" + college_id +
                ", id_user=" + id_user +
                ", uuid=" + uuid +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", role_id=" + role_id +
                '}';
    }
}
