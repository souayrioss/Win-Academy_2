package org.example;
import static org.example.entity.Admins.*;

import static org.example.entity.Enseignants.mainEnseginatn;
import static org.example.librairies.IConstants.*;
public class Main {
    private static DataSerializ dataSerializ;
    public static void main(String[] args) {
        dataSerializ=DataSerializ.getInstance();
        System.out.println("**************Welcome__to__Win__Academy*********");

        if(true)
            while (!dataSerializ.logIn()) {
                System.err.println("Les informations sont incorrect");
            }
        if (dataSerializ.isConnected.getRole_id() == ROLE_ADMIN_ID) {
            mainAdmin();
        }
        if (DataSerializ.isConnected.getRole_id() == ROLE_ENSEIGNANT_ID) {
            mainEnseginatn();
        }
        if (DataSerializ.isConnected.getRole_id() == ROLE_ETUDIANT_ID) {
            System.out.println("Etudianr....");
        }
        dataSerializ.saveData();
    }

}