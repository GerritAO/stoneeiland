package Login;

import users.userObjClass;

import java.util.List;
import java.util.Scanner;

import static users.users.View;

public class Login  {

            public static Boolean LoginForm(){
                List<userObjClass> users = View();

                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter username: ");
                String inputUsername = scanner.nextLine();


                System.out.println("Enter Password");
                String inputPassw = scanner.nextLine();

                checkCred t = new checkCred();
                Boolean InlogCheck = t.UserCheck(inputUsername, inputPassw);

               return InlogCheck;




            }

}
