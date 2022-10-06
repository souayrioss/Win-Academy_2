package com.win_academy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Etudiants extends Users {
    private String code ;
    private String annee_scolaire;
    private ArrayList<Notes> notes ;

    private static String  file = "./src/main/java/data/Etudiants.txt";

    public Etudiants(String fullName, String email, String password, String tel, String code, String annee_scolaire) {
        super(fullName, email, password, tel);
        this.code = code;
        this.annee_scolaire = annee_scolaire;
        this.notes = new ArrayList<Notes>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAnnee_scolaire() {
        return annee_scolaire;
    }

    public void setAnnee_scolaire(String annee_scolaire) {
        this.annee_scolaire = annee_scolaire;
    }

    public ArrayList<Notes> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Notes> note) {
        this.notes = note;
    }

    @Override
    public String toString() {
        return "\n{" +
                "\"code\": " + '\"' + code + '\"'   +
                ", \"uuid\":"+ '\"' + uuid + '\"' +
                ", \"fullName\":"+ '\"' + fullName + '\"' +
                ", \"email\":"+ '\"' + email + '\"' +
                ", \"tel\":"+ '\"' + tel + '\"' +
                "},";
    }
    public static void createEtudiant() throws IOException {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter nom et prenom ");
        String fullName = myObj.nextLine();
        System.out.println("Enter l'email ");
        String email = myObj.nextLine();
        System.out.println("Enter mot du passe ");
        String password = myObj.nextLine();
        System.out.println("Enter numero du telephone ");
        String tel = myObj.nextLine();
        System.out.println("Enter cin ");
        String code = myObj.nextLine();
        System.out.println("Enter cin ");
        String annee_scolaire = myObj.nextLine();
        Etudiants etudiants = new Etudiants(fullName,email,password,tel,code,annee_scolaire);
        System.out.println(etudiants.toString());
        File fichier = new File(file);
        FileWriter fw = new FileWriter(fichier,true);
        PrintWriter pw = new PrintWriter(fw);
        pw.print(etudiants.toString());
        pw.close();
    }
    public static void affichEtudiant() {
        File fichier = new File(file);
        try{
            Scanner scan = new Scanner(fichier);
            while (scan.hasNextLine()){
                String text = scan.nextLine();
                System.out.println(text);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
