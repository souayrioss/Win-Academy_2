package org.example.entity;

import org.example.DataSerializ;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Groups implements Serializable {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id_group;
    private String name_group;
    private String niveau;
    private ArrayList<Etudiants> etudiants ;

    public Groups() {
        this.id_group = count.incrementAndGet();
    }

    public Groups(String name_group, String niveau, ArrayList<Etudiants> etudiants) {
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

    public static void addGroup(Groups newGroup){
        Scanner scanner=new Scanner(System.in);
        System.out.println("insertion d'un nouveau College :");
        System.out.println("veillez saisir le nom de group");
        newGroup.setName_group(scanner.nextLine());
        System.out.println("veillez saisir le niveau de group");
        newGroup.setNiveau(scanner.nextLine());
        DataSerializ.getInstance().group.add(newGroup);
    }

}
