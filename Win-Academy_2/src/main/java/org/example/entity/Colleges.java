package org.example.entity;

import org.example.DataSerializ;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Colleges implements Serializable {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id_college;
    private String name_college;
    private ArrayList<Etudiants> etudiants ;
    private ArrayList<Departements> departements ;


    public Colleges() {
        this.id_college = count.incrementAndGet();
    }

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
    public static void addCollege(Colleges newCollege){
        Scanner scanner=new Scanner(System.in);
        System.out.println("insertion d'un nouveau College :");
        System.out.println("veillez saisir le nom du college");
        newCollege.setName_college(scanner.nextLine());
        DataSerializ.getInstance().colleges.add(newCollege);
    }



}