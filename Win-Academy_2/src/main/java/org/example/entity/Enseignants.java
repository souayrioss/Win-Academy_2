package org.example.entity;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Enseignants extends Users implements Serializable{
    private String cin ;
    private int matiere_id;
    private int Depatement_id;

    public Enseignants() {
        super();
    }

    public Enseignants(String fullName, String email, String password, String tel, String cin) {
        super(fullName, email, password, tel);
        this.cin = cin;
    }
    public String getCin() {return cin;}
    public void setCin(String cin) {
        this.cin = cin;
    }

    public int getMatiere_id() {
        return matiere_id;
    }

    public void setMatiere_id(int matiere_id) {
        this.matiere_id = matiere_id;
    }

    public int getDepatement_id() {
        return Depatement_id;
    }

    public void setDepatement_id(int depatement_id) {
        Depatement_id = depatement_id;
    }

    @Override
    public String toString() {
        return "\nEnseignants{" +
                "cin='" + cin + '\'' +
                ", matiere_id=" + matiere_id +
                ", Depatement_id=" + Depatement_id +
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