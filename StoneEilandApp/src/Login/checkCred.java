package Login;

import users.userObjClass;

import java.util.List;

import static users.users.View;

public class checkCred {
    private List<userObjClass> users;
    public String UserCheck(String usernaam, String passwoord){

            users = View();
            String result = null;
             boolean found = false;
            for(userObjClass user: users){

                if(user.user_name.equals(usernaam) && user.user_password.equals(passwoord)){
                    found = true;
                    result = user.Role +" "+ user.user_name+ " "+ user.DOB.toString();
                    break;
                }
                if (found) {
                    System.out.println("Gebruiker gevonden");
                } else {
                    System.out.println("");
                }

                            }

        return result;
    }
}
