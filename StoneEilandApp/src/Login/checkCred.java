package Login;

import users.userObjClass;

import java.util.List;

import static users.users.View;

public class checkCred {
    private List<userObjClass> users;
    public boolean UserCheck(String usernaam, String passwoord){

            users = View();
            Boolean result = false;
            for(userObjClass user: users){

                if(user.user_name.equals(usernaam) && user.user_password.equals(passwoord)){
                    result = true;
                }
                else {
                    result = false;
                }

            }
            return result;


    }
}
