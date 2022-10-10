package org.example.entity;


import org.example.DataSerializ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static org.example.librairies.IConstants.*;

public class Departements implements Serializable {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id_departement ;
    private String name_departement ;
    private int college_id ;

    public Departements() {
        this.id_departement = count.incrementAndGet();
    }

    public Departements(String name_departement) {
        this.id_departement = count.incrementAndGet();
        this.name_departement = name_departement;
    }

    public int getId_departement() {
        return id_departement;
    }


    public String getName_departement() {
        return name_departement;
    }

    public int getCollege_id() {
        return college_id;
    }

    public void setCollege_id(int college_id) {
        this.college_id = college_id;
    }

    public void setName_departement(String name_departement) {
        this.name_departement = name_departement;
    }

    public static void addDepartement(Departements newDepartement){
        Scanner scanner=new Scanner(System.in);
        System.out.println("insertion d'un nouveau College :");
        System.out.println("veillez saisir le nom du departement");
        newDepartement.setName_departement(scanner.nextLine());
        System.out.println("Quelle college partient cette departement");
        System.out.println("BROOK => 1");
        System.out.println("ZORO => 2");
        int choix ;
        do {
            choix = scanner.nextInt();
        }while (choix < 1 || choix >2);
        if(choix== ID_COLLEGE_BROOK)
            newDepartement.setCollege_id(ID_COLLEGE_BROOK);
        if (choix == ID_COLLEGE_ZORO)
            newDepartement.setCollege_id(ID_COLLEGE_ZORO);
        DataSerializ.getInstance().departement.add(newDepartement);
    }
}
