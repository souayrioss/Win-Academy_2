package com.win_academy;

import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Groups {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id_group;
    private String name_group;
    private String niveau;
    private ArrayList<Etudiants> etudiants ;

    public Groups( String name_group, String niveau, ArrayList<Etudiants> etudiants) {
        this.id_group = count.incrementAndGet();
        this.name_group = name_group;
        this.niveau = niveau;
        this.etudiants = etudiants;
    }

    public int getId_group() {
        return id_group;
    }

    public String getName_group() {
        return name_group;
    }

    public void setName_group(String name_group) {
        this.name_group = name_group;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public ArrayList<Etudiants> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(ArrayList<Etudiants> etudiants) {
        this.etudiants = etudiants;
    }
}
