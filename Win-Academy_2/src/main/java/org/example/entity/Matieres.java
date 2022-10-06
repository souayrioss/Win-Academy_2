package com.win_academy;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Matieres {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id_matiere ;
    private String name_matiere;
    private ArrayList<Sales> sales ;

    public Matieres( String name_matiere) {
        this.id_matiere = count.incrementAndGet();
        this.name_matiere = name_matiere;
        this.sales = new ArrayList<Sales>();
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public String getName_matiere() {
        return name_matiere;
    }

    public void setName_matiere(String name_matiere) {
        this.name_matiere = name_matiere;
    }

    public ArrayList<Sales> getSales() {
        return sales;
    }

    public void setSales(ArrayList<Sales> sales) {
        this.sales = sales;
    }
}
