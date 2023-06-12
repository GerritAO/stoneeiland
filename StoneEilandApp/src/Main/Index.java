package Main;

import activiteiten.actObjeClass;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static activiteiten.activiteit_main.ViewAct;

public class Index {

    public static void main(String[] args) {

        System.out.println("Welcome bij de Stone eiland APP\n ");
        System.out.println("Login om jouw adventure te beginnen\n");
        menuitems();
        System.out.println("\n");

    }
        private static void menuitems(){
            ArrayList menuitems = new ArrayList();
            menuitems.add("0. Booking");
            menuitems.add("1. Activiteiten");
            menuitems.add("2. Houses");

            Scanner userinput = new Scanner(System.in);

            System.out.println("Kies(nummer) een optie");
            for(int i = 0; i < menuitems.size();i++){
                System.out.println(menuitems.get(i));
            }
            System.out.println("Vul je keuze in: " );
            String input = userinput.nextLine();
            int inputint = Integer.parseInt(input);

            if(inputint == 1){
                List<actObjeClass> actvititeiten = ViewAct();
                System.out.println("Een lijst van de Activiteiten " );
                for (actObjeClass actvititeit : actvititeiten) {
                    System.out.println("ID."+actvititeit.id + "  Activiteit Naam:" + actvititeit.act_name+ ", Activiteit Price in $: " + actvititeit.act_price+ " Status:"+ actvititeit.status+ "\n");
                }
                menuitems();

            }
        }
    }



