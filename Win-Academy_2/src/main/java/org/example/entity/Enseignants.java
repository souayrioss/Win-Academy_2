package com.win_academy;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static com.win_academy.Admins.mainAdmin;
import static com.win_academy.Notes.affichNote;
import static com.win_academy.Notes.ajtNote;

public class Enseignants extends Users{
    private String cin ;
    private static String  file = "./src/main/java/data/Enseignants.txt";
    public Enseignants(String fullName, String email, String password, String tel, String cin) {
        super(fullName, email, password, tel);
        this.cin = cin;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }
    @Override
    public String toString() {
        return "\n{" +
                "\"cin\": " + '\"' + cin + '\"'   +
                ", \"uuid\":"+ '\"' + uuid + '\"' +
                ", \"fullName\":"+ '\"' + fullName + '\"' +
                ", \"email\":"+ '\"' + email + '\"' +
                ", \"tel\":"+ '\"' + tel + '\"' +
                "}";
    }
    public static void createEnseignant() throws Exception {
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
        String cin = myObj.nextLine();
        Enseignants enseignants = new Enseignants(fullName,email,password,tel,cin);
        File fichier = new File(file);
        FileWriter fw = new FileWriter(fichier,true);
        PrintWriter pw = new PrintWriter(fw);
        pw.print(enseignants.toString());
        pw.close();
        mainAdmin();
    }
    public static void affichEnseignant() {
        File fichier = new File(file);
        try{
            Scanner scan = new Scanner(fichier);
            while (scan.hasNextLine()){
                String text = scan.nextLine();
                System.out.println(text);
                mainAdmin();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void logEnseignant() throws Exception {
        System.out.println("\t******************************************************************\n");
        System.out.println("\t\t----------------Enter__Your__Email__&&__Password----------------\n");
        System.out.println("\t******************************************************************");
        String email;
        String password;
        Scanner MyChoix = new Scanner(System.in);
        System.out.println("Enter votre email");
        email = MyChoix.nextLine();
        System.out.println("Enter votre password");
        password = MyChoix.nextLine();
        if(findEnseignant(new File(file),email,password)){
            mainEnseignant();
        }else
            System.out.println("user not found");
    }
    public static boolean findEnseignant(File f, String email , String password) throws IOException {
        boolean result = false;
        Scanner in = null;
        try {
            in = new Scanner(new FileReader(f));
            while(in.hasNextLine() && !result) {
                String str = in.nextLine();
                if (str.contains(email)  &&  str.contains(password) )
                    return true;
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            try { in.close() ; } catch(Exception e) { e.printStackTrace(); }
        }
        return false;

    }
    public static void mainEnseignant() throws Exception {
        int choix;
        ArrayList<Notes> notes = new ArrayList<Notes>();
        System.out.println("\t******************************************************************\n");
        System.out.println("\t\t----------------Hello__Enseignant----------------\n");
        System.out.println("\t******************************************************************");
        do{
        System.out.println("\t Ajouter  des note : 1");
        System.out.println("\t Affichage des note : 2 ");
        System.out.println("\t Modifier des note: 3 ");
        System.out.println("\t Supprimer des note : 4");
        System.out.println("\t Affiche la fiche signalitique  : 5");



            Scanner MyChoix = new Scanner(System.in);
            System.out.println("Enter votre choix entre 0 et 5");
            choix = MyChoix.nextInt();

        switch (choix) {
            case 1:

                ajtNote(notes);
                break;
            case 2:
                affichNote(notes);
                break;
            case 3:
                // modifNote();
                break;
            case 4:
                //suppNote();
                break;
        }
        }while (choix !=0);
    }
}
