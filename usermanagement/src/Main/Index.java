package Main;
import Users.userObjClass;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

            System.out.println("nothing yet");
        }
        if(inputint == 2){

            System.out.println("nothing yet");
        }
    }



}
