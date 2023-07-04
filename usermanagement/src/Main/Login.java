package Main;

import Users.userObjClass;

import java.util.List;
import java.util.Scanner;

import static Users.users.View;

public class Login {

    public static String LoginForm(){
        List<userObjClass> users = View();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String inputUsername = scanner.nextLine();


        System.out.println("Enter Password");
        String inputPassw = scanner.nextLine();

        checkCred t = new checkCred();
        String InlogCheck = t.UserCheck(inputUsername, inputPassw);

        return InlogCheck;

    }

}
