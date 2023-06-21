package Main;

import activiteiten.actObjeClass;
import booking.BookingObjClass;
import com.mysql.cj.log.Log;
import houses.housObjClass;
import Login.Login;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Login.Login.LoginForm;
import static activiteiten.activiteit_main.ViewAct;
import static booking.booking_main.ViewBoekingen;
import static houses.house_main.ViewHuizen;

public class Index {

    public static void main(String[] args) {

        System.out.println("Welcome bij de Stone eiland APP\n ");
        System.out.println("Login om jouw adventure te beginnen\n");
//        boolean t = LoginForm();
//        if(t == true){
//            menuitems();
//        }
//        if(t == false){
//            System.out.println("Gebruiker heeft geen rechten of toegang tot het systeem, contact de beheerder");
//            LoginForm();
//        }
        menuitems();
        System.out.println("\n");


    }
        private static void menuitems(){
            ArrayList menuitems = new ArrayList();
            menuitems.add("0. Boeking");
            menuitems.add("1. Activiteiten");
            menuitems.add("2. Houses");
            menuitems.add("3. Logout");

            Scanner userinput = new Scanner(System.in);

            System.out.println("Kies(nummer) een optie");
            for(int i = 0; i < menuitems.size();i++){
                System.out.println(menuitems.get(i));
            }
            System.out.println("Vul je keuze in: " );
            String input = userinput.nextLine();
            int inputint = Integer.parseInt(input);

            if(inputint == 0){
                List<BookingObjClass> boekingen = ViewBoekingen();
                System.out.println("Een lijst van Boekingen " );
                for (BookingObjClass boekings : boekingen) {
                    System.out.println("ID."+ boekings.id + "| Naam:" + boekings.user + "| Huis Price in $: " + boekings.huis+ "| Status:"+ boekings.activiteiten+ "| Status:");
                }
                menuitems();
            }

            if(inputint == 1){
                List<actObjeClass> actvititeiten = ViewAct();
                System.out.println("Een lijst van de Activiteiten " );
                for (actObjeClass actvititeit : actvititeiten) {
                    System.out.println("ID."+actvititeit.id + "  Activiteit Naam:" + actvititeit.act_name+ ", Activiteit Price in $: " + actvititeit.act_price+ " Status:"+ actvititeit.status+ "\n");
                }
                menuitems();

            }
            if(inputint == 2){
                List<housObjClass> huizen = ViewHuizen();
                System.out.println("Een lijst van Huizen " );
                for (housObjClass huis : huizen) {
                    System.out.println("ID."+ huis.id + "| Naam:" + huis.house_name+ "| Huis Price in $: " + huis.house_price+ "| Status:"+ huis.status+ "\n");
                }
                menuitems();
            }
            if(inputint == 3){
                System.out.println("U bent succesvol uitgelogd\n");
                System.out.println("Welcome bij de Stone eiland APP\n ");
                System.out.println("Login om jouw adventure te beginnen\n");
                LoginForm();
            }
        }
    }



