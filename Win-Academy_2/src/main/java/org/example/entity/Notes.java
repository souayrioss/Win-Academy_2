package com.win_academy;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static com.win_academy.Admins.mainAdmin;
import static com.win_academy.Enseignants.mainEnseignant;

public class Notes {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id_note;
    private float note;
    private String matiere;

    public Notes(float note, String matiere) {
        this.id_note = count.incrementAndGet();
        this.note = note;
        this.matiere = matiere;
    }

    public static void ajtNote(ArrayList<Notes> notes)  {
        int numNote;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter la matiere ");
        String matiere = myObj.nextLine();
        do {
            System.out.println("Enter nombre du notes");
            numNote = myObj.nextInt();
        }while (numNote < 1);

        for (int i = 0 ; i < numNote;i++) {
            System.out.println("Enter la note " + ++i);
            Float note = myObj.nextFloat();
            notes.add(new Notes(note, matiere));
        }

    }
    public static void affichNote(ArrayList<Notes> notes)  {
        System.out.println("affiiiiche note");
        Iterator<Notes> n = notes.iterator();
        while (n.hasNext()){
            Notes note = n.next();
            System.out.println(note.toString());
        }
    }


    public int getId_note() {
        return id_note;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    @Override
    public String toString() {
        return "Notes{" +
                ", note=" + note +
                ", matiere='" + matiere + '\'' +
                '}';
    }
}
