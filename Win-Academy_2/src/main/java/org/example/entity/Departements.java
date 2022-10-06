package com.win_academy;


import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Departements {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id_departement ;
    private String name_departement ;
    private ArrayList<Enseignants> enseignants ;
    private ArrayList<Sales> sales ;

    public Departements( String name_departement) {
        this.id_departement = count.incrementAndGet();
        this.name_departement = name_departement;
        this.enseignants = new ArrayList<Enseignants>();
        this.sales = new ArrayList<Sales>();
    }

    public int getId_departement() {
        return id_departement;
    }


    public String getName_departement() {
        return name_departement;
    }

    public void setName_departement(String name_departement) {
        this.name_departement = name_departement;
    }


    public ArrayList<Enseignants> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(ArrayList<Enseignants> enseignants) {
        this.enseignants = enseignants;
    }

    public ArrayList<Sales> getSales() {
        return sales;
    }

    public void setSales(ArrayList<Sales> sales) {
        this.sales = sales;
    }
}
