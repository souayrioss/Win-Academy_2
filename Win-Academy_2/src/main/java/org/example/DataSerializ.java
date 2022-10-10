package org.example;
import org.example.entity.*;
import static org.example.librairies.IConstants.*;
import java.io.*;
import java.util.*;



public class DataSerializ implements Serializable {
    private static DataSerializ dataSerializ;
    public static Users isConnected=null;
    private static final String filePath="./src/main/java/org/example/data.txt";
    public List<Users> users;
    public Set<Roles> roles;
    public List<Colleges> colleges;

    public  List<Groups> group;
    public Set<Departements> departement;

    public DataSerializ() {

        users = new ArrayList<>();
        roles =new HashSet<>();
        colleges = new ArrayList<>();
        group = new ArrayList<>();
        departement = new HashSet<>();

    }

    public static DataSerializ getInstance(){
        if(DataSerializ.dataSerializ==null) {
            if(!ChargeData()){
                dataSerializ=new DataSerializ();
                dataSerializ.CreateData();
            };
        }
        return dataSerializ;
    }
    public  static boolean logIn(){
        System.out.println("Veillez saisir votre email");
        Scanner scanner=new Scanner(System.in);
        String email=scanner.nextLine();
        System.out.println("Veillez saisir votre Mot de passe");
        String password=scanner.nextLine();
        Optional<Users> optionalUser=DataSerializ.getInstance().users.stream().filter(user->user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)).findFirst();
        if(optionalUser.isPresent()){
            DataSerializ.isConnected = optionalUser.get();
            return true;
        }
        return false;
    }

    private static boolean ChargeData(){
        if(!new File(filePath).exists()) {
            System.out.println("no previous data found!");
            return false;
        }
        try{
            System.out.println("reading object from file");
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(filePath));
            dataSerializ= (DataSerializ) ois.readObject();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public void saveData(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeObject(dataSerializ);
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void CreateData(){

        this.roles.add(new Roles(ROLE_ADMIN_ID,"Admin"));
        this.roles.add(new Roles(ROLE_ENSEIGNANT_ID,"Enseignant"));
        this.roles.add(new Roles(ROLE_ETUDIANT_ID,"Etudiant"));

        Admins admin = new Admins("Marsall D. Teach","teach@gmail.com","azerty","073456782","MD674675");
        admin.setRole_id(ROLE_ADMIN_ID);
        this.users.add(admin);

        Enseignants enseignantHannane = new Enseignants("Hanane Jabane","hanane@gmail.com","azerty","0711111111","HJ424581");
        enseignantHannane.setRole_id(ROLE_ENSEIGNANT_ID);
        enseignantHannane.setMatiere_id(ID_MATIERE_PHP);
        enseignantHannane.setDepatement_id(ID_DEPARTEMENT_PHP);
        this.users.add(enseignantHannane);

        Enseignants enseignantBouchra = new Enseignants("Bouchra Merzak","bouchra@gmail.com","azerty","0700000000","BM758761");
        enseignantBouchra.setRole_id(ROLE_ENSEIGNANT_ID);
        enseignantBouchra.setDepatement_id(ID_DEPARTEMENT_JAVA);
        enseignantBouchra.setMatiere_id(ID_MATIERE_JAVA);
        this.users.add(enseignantBouchra);

        Etudiants etudiantOussama=new Etudiants("Oussama Souayri","souayri@gmail.com","azerty","073687872","ZA312313","2022");
        etudiantOussama.setRole_id(ROLE_ETUDIANT_ID);
        etudiantOussama.setCollege_id(ID_COLLEGE_ZORO);
        etudiantOussama.setGroup_id(ID_GROUP_JAVA);
        this.users.add(etudiantOussama);

        Etudiants etudiantRaouya=new Etudiants("Raouya El_yaagoubi","raouya@gmail.com","azerty","073234567","RG323883","2022");
        etudiantRaouya.setRole_id(ROLE_ETUDIANT_ID);
        etudiantRaouya.setCollege_id(ID_COLLEGE_ZORO);
        etudiantRaouya.setGroup_id(ID_GROUP_JAVA);
        this.users.add(etudiantRaouya);

        Etudiants etudiantSalim=new Etudiants("Salim Ahmed","ahmed@gmail.com","azerty","079876598","AS875865","2021");
        etudiantSalim.setRole_id(ROLE_ETUDIANT_ID);
        etudiantSalim.setCollege_id(ID_COLLEGE_ZORO);
        etudiantSalim.setGroup_id(ID_GROUP_JAVASCRIPT_1);
        this.users.add(etudiantSalim);

        Etudiants etudiantYasser=new Etudiants("Yasser Mahfoudi","yasser@gmail.com","azerty","076986872","YM356878","2023");
        etudiantYasser.setRole_id(ROLE_ETUDIANT_ID);
        etudiantYasser.setCollege_id(ID_COLLEGE_BROOK);
        etudiantYasser.setGroup_id(ID_GROUP_JAVASCRIPT_2);
        this.users.add(etudiantYasser);

    }
}
