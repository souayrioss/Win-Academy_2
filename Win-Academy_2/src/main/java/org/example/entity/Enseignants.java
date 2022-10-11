package org.example.entity;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.example.entity.Colleges.addCollege;
import static org.example.entity.Etudiants.*;
import static org.example.entity.Groups.addGroup;
import static org.example.librairies.IConstants.*;

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
    public static void mainEnseginatn(){
        Map<Integer,String> options=new HashMap<>();
        options.put(DIS_ETUDIANT,"Afficher les  etudiants ");
        options.put(DIS_ETUDIANT_DEPARTEMENT,"Afficher les  etudiants par groupe");
        options.put(ADD_NOTE,"Ajouter une note");
        options.keySet().stream().sorted().forEach(k-> System.out.println(k+" => "+options.get(k)));
        Scanner scanner=new Scanner(System.in);
        int option;
        do{
            System.out.println("Tapez le numéro correspondant à l'option de votre choix:\n");
            option=scanner.nextInt();
        }while(!(options.containsKey(option)));
        switch(option){
            case DIS_ETUDIANT:
                displayEtudiant();
                break;
            case DIS_ETUDIANT_DEPARTEMENT:
                displayEtudiantParGroup().forEach(e-> System.out.println(e.toString()));
                break;
            case ADD_NOTE:
                //AddNote();
                break;
        }
    }
}