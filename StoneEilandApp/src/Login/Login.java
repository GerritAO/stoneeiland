package Login;

import com.mysql.cj.log.Log;
import users.userObjClass;

import java.util.List;
import java.util.Scanner;

import static users.users.View;

public class Login {

            public static void Login(){
                List<userObjClass> users = View();

                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter username: ");
                String inputUsername = scanner.nextLine();


                System.out.println("Enter Password");
                String inputPassw = scanner.nextLine();





            }

}
