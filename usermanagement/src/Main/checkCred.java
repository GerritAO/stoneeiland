package Main;



import Users.userObjClass;

import java.util.List;

import static Users.users.View;


public class checkCred {
    private List<userObjClass> users;
    public String UserCheck(String usernaam, String passwoord){

            users = View();
            String result = "";
            for(userObjClass user: users){

                if(user.user_name.equals(usernaam) && user.user_password.equals(passwoord)){
                    result = user.Role +" "+ user.user_name + " " + user.DOB.toString();
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
