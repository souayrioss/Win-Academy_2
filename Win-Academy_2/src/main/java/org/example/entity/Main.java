package com.win_academy;

import java.io.IOException;
import java.util.Scanner;

import static com.win_academy.Admins.logAdmin;
import static com.win_academy.Enseignants.logEnseignant;
import static com.win_academy.Users.affichUser;
import static com.win_academy.Users.choixUser;

public class Main {
    public static void main (String[] args) throws Exception {
            System.out.println("\t******************************************************************\n");
            System.out.println("\t\t----------------------Who_Are_You-----\n");
            System.out.println("\t******************************************************************");
            System.out.println("\t Admin : 1\n");
            System.out.println("\t Enseignant : 2 \n");
            System.out.println("\t Etudiant : 3 \n");
        int choix;
        do{
            Scanner MyChoix = new Scanner(System.in);
            System.out.println("Enter votre choix entre 1 et 3");
            choix = MyChoix.nextInt();
        }while (choix>=3);
        switch (choix) {
            case 1:
                logAdmin();
                break;
            case 2:
                logEnseignant();
                break;
            case 3:
                //logEtudiant();
                break;
        }
    }
}
/*            System.out.println("\t Creation de compte : 1\n");
            System.out.println("\t Affichage des comptes : 2 \n");
            System.out.println("\t Operation : 3 \n");
            System.out.println("\t Rechercher par CIN  taper : 4\n");
            System.out.println("\t Pour les client fidele  :5\n");
            System.out.println("\t QUITTER  :0\n");
            int choix;
            do{
                Scanner MyChoix = new Scanner(System.in);
                System.out.println("Enter votre choix entre 0 et 5");
                choix = MyChoix.nextInt();
            }while (choix>5);
        switch (choix) {
            case 1:
                choixUser();
                break;
            case 2:
                affichUser();
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
        }*/