package com.win_academy;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Colleges {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id_college;
    private String name_college;
    private ArrayList<Etudiants> etudiants ;
    private ArrayList<Departements> departements ;



    public Colleges(String name_college) {
        this.id_college = count.incrementAndGet();
        this.name_college = name_college;
        this.departements = new ArrayList<Departements>();
        this.etudiants = new ArrayList<Etudiants>();


    }



    public int getId_college() {
        return id_college;
    }

    public String getName_college() {
        return name_college;
    }

    public void setName_college(String name_college) {
        this.name_college = name_college;
    }

    public ArrayList<Etudiants> getEtudiant() {
        return etudiants;
    }

    public void setEtudiant(ArrayList<Etudiants> etudiant) {
        etudiants = etudiant;
    }

    public ArrayList<Departements> getDepartement() {
        return departements;
    }

    public void setDepartement(ArrayList<Departements> departement) {
        departements = departement;
    }
}