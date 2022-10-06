package com.win_academy;



import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import java.io.*;
import java.util.Scanner;

public class Admins extends Users{
    private static String json = "./src/main/java/data/Admins.txt" ;
    private String cin ;

    public Admins(String fullName, String email, String password, String tel, String cin) {
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
                ", \"tel\":"+ '\"' + password + '\"' +
                ", \"tel\":"+ '\"' + tel + '\"' +
                "},";
    }
    public static void createAdmin() throws Exception {
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
        Admins admins = new Admins(fullName,email,password,tel,cin);
        File fichier = new File(json);
        FileWriter fw = new FileWriter(fichier,true);
        PrintWriter pw = new PrintWriter(fw);
        pw.print(admins.toString());
        pw.close();
        mainAdmin();
    }
    public static void affichAdmin() {
        JSONParser jsonP = new JSONParser();
        try(FileReader reader =new FileReader(json) ){
            Object obj = jsonP.parse(reader);
            JSONArray AdminList =(JSONArray)obj;
            System.out.println(AdminList.indexOf(1));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            mainAdmin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void logAdmin() throws Exception {
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
        if(findAdmin(new File(json),email,password)){
            mainAdmin();
        }else
            System.out.println("user not found");
    }
    public static boolean findAdmin(File f, String email , String password) throws IOException {
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
    public static void modifAdmin(){}
    public static void suppAdmin(){
        Scanner in = null;
        String currentLine;
        String data[];
        String email;

        Scanner MyChoix = new Scanner(System.in);
        System.out.println("Enter votre email");
        email = MyChoix.nextLine();
        try {
            in = new Scanner(new FileReader(json));
            FileWriter fw = new FileWriter("text.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(json);
            BufferedReader br = new BufferedReader(fr);

            while(in.hasNextLine() ) {
                String str = in.nextLine();
                if (str.contains(email))
                    pw.println(str);
            }
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            try { in.close() ; } catch(Exception e) { e.printStackTrace(); }
        }

    }

    public static void mainAdmin() throws Exception {
        System.out.println("\t******************************************************************\n");
        System.out.println("\t\t----------------Hello__Admin----------------\n");
        System.out.println("\t******************************************************************");
        System.out.println("\t Creation de compte : 1\n");
        System.out.println("\t Affichage des comptes : 2 \n");
        System.out.println("\t Modifier des comptes: 3 \n");
        System.out.println("\t Supprimer des comptes : 4\n");

        int choix;
        do{
            Scanner MyChoix = new Scanner(System.in);
            System.out.println("Enter votre choix entre 0 et 5");
            choix = MyChoix.nextInt();
        }while (choix < 1 || choix>4);
        switch (choix) {
            case 1:
                choixUser();
                break;
            case 2:
                affichUser();
                break;
            case 3:
                modifUser();
                break;
            case 4:
                suppUser();
                break;
        }
    }



}
/*


 */
