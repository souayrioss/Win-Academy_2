package org.example.entity;

import org.example.DataSerializ;

import java.io.*;
import java.util.*;

import static org.example.librairies.IConstants.*;

public class Etudiants extends Users implements Serializable {
    private String code ;
    private String annee_scolaire;
    private int group_id;
    private int college_id;
    public Etudiants() {
    }

    public Etudiants(String fullName, String email, String password, String tel, String code, String annee_scolaire) {
        super(fullName, email, password, tel);
        this.code = code;
        this.annee_scolaire = annee_scolaire;
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

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public int getCollege_id() {
        return college_id;
    }

    public void setCollege_id(int college_id) {
        this.college_id = college_id;
    }

    @Override
    public String toString() {
        return "\nEtudiants{" +
                "code='" + code + '\'' +
                ", annee_scolaire='" + annee_scolaire + '\'' +
                ", group_id=" + group_id +
                ", id_college=" + college_id +
                ", id_user=" + id_user +
                ", uuid=" + uuid +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", role_id=" + role_id +
                '}';
    }
    public static void displayEtudiant(){
        List<Users> listEtudiant= DataSerializ.getInstance().users.stream().filter(user->user.getRole_id() == ROLE_ETUDIANT_ID).toList();
        Iterator<Users> it = listEtudiant.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
    public static List<Etudiants> displayEtudiantParGroup(){
        System.out.println("1 . JAVA \n");
        System.out.println("2 . JAVASCRIPT_1 \n");
        System.out.println("3 . JAVASCRIPT_2 \n");
        Scanner scanner=new Scanner(System.in);
        int choix =scanner.nextInt();

        List<Users> listEtudiant= DataSerializ.getInstance().users.stream().filter(user->user.getRole_id() == ROLE_ETUDIANT_ID).toList();
        Iterator<Users> it = listEtudiant.iterator();
        List<Etudiants> e = new ArrayList<>();
        while(it.hasNext()) {
            Etudiants etudiant = (Etudiants)it.next();
            if (etudiant.group_id == choix  ) {
                e.add(etudiant);
            }

        }
        return e;
    }
}
