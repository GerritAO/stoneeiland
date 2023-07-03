package Login;

import users.userObjClass;

import java.util.List;

import static users.users.View;

public class checkCred {
    private List<userObjClass> users;
    public String UserCheck(String usernaam, String passwoord){

            users = View();
            String result = "";
            for(userObjClass user: users){

                if(user.user_name.equals(usernaam) && user.user_password.equals(passwoord)){
                    result = user.Role +" "+ user.user_name;
                    break;
                }
                else {
                    result = "Gebruiker heeft geen rechten of bestaat niet";
                    break;
                }

            }

        return result;
    }
}
