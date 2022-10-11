package org.example.entity;
import org.example.DataSerializ;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import static org.example.entity.Colleges.addCollege;
import static org.example.entity.Departements.addDepartement;
import static org.example.entity.Groups.addGroup;
import static org.example.librairies.IConstants.*;


public class Admins extends Users implements Serializable{
    private static final String json = "./src/main/java/data/Admins.txt" ;
    private String cin ;

    public Admins(String fullName, String email, String password, String tel, String cin) {
        super(fullName, email, password, tel);
        this.cin = cin;
    }

    public Admins() {
    }


    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    @Override
    public String toString() {
        return "\nAdmins{" +

                "cin='" + cin + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", role_id=" + role_id +
                '}';
    }
    public static void mainAdmin(){
        int option;
        do {
        Map<Integer,String> options=new HashMap<>();
        options.put(ADD_ETUDIANT,"Ajouter un etudiant ");
        options.put(ADD_ENSEIGNANT,"Ajouter un enseignant");
        options.put(ADD_ADMIN,"Ajouter un admin");
        options.put(ADD_GROUP,"Ajouter Un groupe");
        options.put(ADD_COLLEGE,"Ajouter Une college");
        options.put(ADD_DEPARTEMENT,"Ajouter Une departement");
        options.put(ADD_SALLE,"Ajouter Une sale");
        options.keySet().stream().sorted().forEach(k-> System.out.println(k+" => "+options.get(k)));
        Scanner scanner=new Scanner(System.in);

        do{
            System.out.println("Tapez le numéro correspondant à l'option de votre choix:\n");
            option=scanner.nextInt();
        }while(!(options.containsKey(option)));
        switch(option){
            case ADD_ETUDIANT:
                menuAddUser(ROLE_ETUDIANT_ID);
                break;
            case ADD_ENSEIGNANT:
                menuAddUser(ROLE_ENSEIGNANT_ID);
                break;
            case ADD_ADMIN:
                menuAddUser(ROLE_ADMIN_ID);
                break;
            case ADD_GROUP:
                Groups newGroup = new Groups();
                addGroup(newGroup);
                break;
            case ADD_COLLEGE:
                Colleges newCollege = new Colleges();
                addCollege(newCollege);
                break;
            case ADD_DEPARTEMENT:
                Departements newDepartement = new Departements();
                addDepartement(newDepartement);
                break;
        }
        }while (option!=0);
    }
    public  static void menuAddUser(int newUserRole){
        Users newUser = new Users() {
        };
        String userType="";
        switch (newUserRole){
            case ROLE_ETUDIANT_ID :
                newUser=new Etudiants();
                userType=" Etudiant ";
                break;
            case ROLE_ENSEIGNANT_ID:
                newUser=new Enseignants();
                userType=" Enseignant ";
                break;
            case ROLE_ADMIN_ID:
                newUser=new Admins();
                userType=" Admin ";
                break;
        }
        Scanner scanner=new Scanner(System.in);
        System.out.println("insertion d'un nouveau "+userType+":");
        System.out.println("veillez saisir le nom de l'"+userType);
        newUser.setFullName(scanner.nextLine());
        System.out.println("veillez saisir l'email de l'"+ userType );
        newUser.setEmail(scanner.nextLine());
        System.out.println("veillez saisir le mot de pass de l'"+userType);
        newUser.setPassword(scanner.nextLine());
        System.out.println("veillez saisir le numero de telphone de l'"+userType);
        newUser.setTel(scanner.nextLine());
        switch (newUserRole){
            case ROLE_ETUDIANT_ID :
                newUser.setRole_id(ROLE_ETUDIANT_ID);
                System.out.print("veillez saisir le code de l'"+userType + " : " );
                ((Etudiants)newUser).setCode(scanner.nextLine());
                System.out.print("veillez saisir l' annee_scolaire de l'"+userType + " : " );
                ((Etudiants)newUser).setAnnee_scolaire(scanner.nextLine());
                System.out.println("veillez saisir le group de l'"+userType + " : " );
                System.out.println("JAVA => 1");
                System.out.println("JAVASCRIPT_1 => 2");
                System.out.println("JAVASCRIPT_2 => 3");
                int choix ;
                do {
                    System.out.print("veillez entrer votre choix : ");
                    choix = scanner.nextInt();
                }while (choix < 1 || choix >2);
                if(choix== ID_GROUP_JAVA)
                    ((Etudiants)newUser).setGroup_id(ID_GROUP_JAVA);
                if (choix == ID_GROUP_JAVASCRIPT_1)
                    ((Etudiants)newUser).setGroup_id(ID_GROUP_JAVASCRIPT_1);
                if (choix == ID_GROUP_JAVASCRIPT_2)
                    ((Etudiants)newUser).setGroup_id(ID_GROUP_JAVASCRIPT_2);
                System.out.println("Quelle college partient ce "+userType + " : ");
                System.out.println("BROOK => 1");
                System.out.println("ZORO => 2");
                do {
                    System.out.print("veillez entrer votre choix : ");
                    choix = scanner.nextInt();
                }while (choix < 1 || choix >2);
                if(choix== ID_COLLEGE_BROOK)
                    ((Etudiants)newUser).setCollege_id(ID_COLLEGE_BROOK);
                if (choix == ID_COLLEGE_ZORO)
                    ((Etudiants)newUser).setCollege_id(ID_COLLEGE_ZORO);
                break;
            case ROLE_ENSEIGNANT_ID:
                newUser.setRole_id(ROLE_ENSEIGNANT_ID);
                System.out.println("veillez saisir le CIN de l'"+userType);
                ((Enseignants)newUser).setCin(scanner.nextLine());
                System.out.println("Quelle Deppartement partient ce "+userType + " : ");
                System.out.println("JAVA => 1");
                System.out.println("JAVASCRIPT => 2");
                System.out.println("PHP => 3");
                System.out.println(".NET => 4");
                do {
                    System.out.print("veillez entrer votre choix : ");
                    choix = scanner.nextInt();
                }while (choix < 1 || choix >4);
                if(choix== ID_DEPARTEMENT_JAVA){
                    ((Enseignants)newUser).setDepatement_id(ID_DEPARTEMENT_JAVA);
                    ((Enseignants)newUser).setMatiere_id(ID_MATIERE_JAVA);
                }
                else if (choix == ID_DEPARTEMENT_JAVASCRIPT){
                    ((Enseignants)newUser).setDepatement_id(ID_DEPARTEMENT_JAVASCRIPT);
                    ((Enseignants)newUser).setMatiere_id(ID_MATIERE_JAVASCRIPT);
                }
                else if(choix== ID_DEPARTEMENT_PHP){
                    ((Enseignants)newUser).setDepatement_id(ID_DEPARTEMENT_PHP);
                    ((Enseignants)newUser).setMatiere_id(ID_MATIERE_PHP);
                }
                else if (choix == ID_DEPARTEMENT_DOT_NET){
                    ((Enseignants)newUser).setDepatement_id(ID_DEPARTEMENT_DOT_NET);
                    ((Enseignants)newUser).setMatiere_id(ID_MATIERE_DOT_NET);
                }
                break;
            case ROLE_ADMIN_ID:
                newUser.setRole_id(ROLE_ADMIN_ID);
                System.out.println("veillez saisir le CIN de l'"+userType);
                ((Admins)newUser).setCin(scanner.nextLine());
                break;
        }
        DataSerializ.getInstance().users.add(newUser);
    }
}

