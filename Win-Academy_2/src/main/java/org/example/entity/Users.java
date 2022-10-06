package com.win_academy;

import javax.management.relation.Role;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import static com.win_academy.Admins.*;
import static com.win_academy.Enseignants.affichEnseignant;
import static com.win_academy.Enseignants.createEnseignant;
import static com.win_academy.Etudiants.affichEtudiant;
import static com.win_academy.Etudiants.createEtudiant;

abstract public class Users {
    private static final AtomicInteger count = new AtomicInteger(0);
    protected final int id_user;
    protected UUID uuid;
    protected String fullName;
    protected String email;
    protected String password;
    protected String tel;

    public Users( String fullName, String email, String password, String tel) {
        this.id_user = count.incrementAndGet();
        this.uuid = UUID.randomUUID();
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.tel = tel;
    }

    public static void choixUser() throws Exception {
        System.out.println("\t Admin : 1\n");
        System.out.println("\t Enseignant : 2 \n");
        System.out.println("\t Etudiant : 3 \n");
        int choix;
        do{
            Scanner MyChoix = new Scanner(System.in);
            System.out.println("Enter votre choix entre 1 et 3");
            choix = MyChoix.nextInt();
        }while (choix<1 || choix>3);
        switch (choix) {
            case 1:
                createAdmin();
                break;
            case 2:
                createEnseignant();
                break;
            case 3:
                createEtudiant();
                break;

        }
    }
    public static void affichUser(){
        System.out.println("\t Admin : 1\n");
        System.out.println("\t Enseignant : 2 \n");
        System.out.println("\t Etudiant : 3 \n");
        int choix;
        do{
            Scanner MyChoix = new Scanner(System.in);
            System.out.println("Enter votre choix entre 1 et 3");
            choix = MyChoix.nextInt();
        }while (choix<1 || choix>3);
        switch (choix) {
            case 1:
                affichAdmin();
                break;
            case 2:
                affichEnseignant();
                break;
            case 3:
                affichEtudiant();
                break;
        }
    }
    public static void modifUser(){
        System.out.println("\t Admin : 1\n");
        System.out.println("\t Enseignant : 2 \n");
        System.out.println("\t Etudiant : 3 \n");
        int choix;
        do{
            Scanner MyChoix = new Scanner(System.in);
            System.out.println("Enter votre choix entre 1 et 3");
            choix = MyChoix.nextInt();
        }while (choix<1 || choix>3);
        switch (choix) {
            case 1:
                modifAdmin();
                break;
            case 2:
                affichEnseignant();
                break;
            case 3:
                affichEtudiant();
                break;
        }
    }
    public static void suppUser(){
        System.out.println("\t Admin : 1\n");
        System.out.println("\t Enseignant : 2 \n");
        System.out.println("\t Etudiant : 3 \n");
        int choix;
        do{
            Scanner MyChoix = new Scanner(System.in);
            System.out.println("Enter votre choix entre 1 et 3");
            choix = MyChoix.nextInt();
        }while (choix<1 || choix>3);
        switch (choix) {
            case 1:
                suppAdmin();
                break;
            case 2:
                affichEnseignant();
                break;
            case 3:
                affichEtudiant();
                break;
        }
    }
    public int getId_user() {
        return id_user;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


}
