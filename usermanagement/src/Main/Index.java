package Main;
import Users.userObjClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static Users.users.Insert_user;
import static Users.users.View;

public class Index {
    public static void main(String[] args) {

        System.out.println("Welcome bij de usermanagement Portal\n ");
        System.out.println("Hier kan je gebruikers Bewerken\n");

        menuitems();
        System.out.println("\n");
    }
    private static void menuitems(){
        ArrayList menuitems = new ArrayList();
        menuitems.add("0. Gebruikers lijst");
        menuitems.add("1. Gebruikers Toevoegen");
        menuitems.add("2. Gebruikers Bewerken");

        Scanner userinput = new Scanner(System.in);

        System.out.println("Kies(nummer) een optie");
        for(int i = 0; i < menuitems.size();i++){
            System.out.println(menuitems.get(i));
        }

        System.out.println("Vul je keuze in: " );
        String input = userinput.nextLine();
        int inputint = Integer.parseInt(input);
        if(inputint == 0){
            List<userObjClass> users = View();

            for (userObjClass user : users) {
                System.out.println(user.id + ":  Naam:" + user.user_name + ", Achternaam: " + user.user_lastname + ", DOB: " + user.DOB + ", Rol: " + user.Role + ", Status: " +  user.Status + "\n");
            }
         menuitems();

        }if(inputint == 1){
            String user_name="";
            String user_password="";
            String user_lastname="";
            LocalDate DOB=null;
            String role="";
            String status="";

            System.out.println("Welkom bij het scherm voor het invoeren van een gebruiker\n");
            user_name = GetName(user_name);
            user_password = GetPassword(user_password);
            user_lastname = GetLastname(user_lastname);
            DOB = GetDOB(DOB);
            role = GetRole(role);
            status = "Actief";
            boolean result = Insert_user(user_name,user_password,user_lastname, DOB, role,status);
            if(result== true){
                System.out.println("Gebruiker succesvol toegevoegd");
            }
            if (result==false){
                System.out.println("fout opgetreden bij het invoeren van een gebruiker");
            }
            menuitems();


        }
        if(inputint == 2){

            System.out.println("nothing yet");
        }
    }

    private static String GetName(String name){
        System.out.println("Naam: ");
        name = getUserStringInput();
        return name;
    }
    private static String GetLastname(String achternaam){
        System.out.println("Achternaam: ");
        achternaam = getUserStringInput();
        return achternaam;
    }
    private static String GetPassword(String password){
        System.out.println("Passwoord: ");
        password = getUserStringInput();
        return password;
    }
    public static String GetRole(String role){
        System.out.println("role: ");
        role = getUserStringInput();
        return role;
    }
    public static LocalDate GetDOB(LocalDate DOB){
        System.out.println("DOB (yyyy-mm-dd): ");
        DOB = getUserDateInput();
        return DOB;
    }



    public static int getUserIntInput() {
        Scanner userIntInput = new Scanner(System.in);
        return userIntInput.nextInt();
    }
    public static String getUserStringInput() {
        Scanner userStringInput = new Scanner(System.in);
        return userStringInput.nextLine();
    }
    public static LocalDate getUserDateInput() {
        Scanner userDateInput = new Scanner(System.in);
        String userInput = userDateInput.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        return LocalDate.parse(userInput, formatter);
    }



}
