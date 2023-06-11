
package Users;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class users {


        public static List<userObjClass> View(){
                view_users t = new view_users();

                String query = "SELECT * FROM st_users";
                List<userObjClass> userList =  t.getUsers(query);
                return userList;

        }

        public static boolean Insert_user(String user_name, String user_password, String user_lastname, LocalDate DOB, String role, String status){
               create_users u = new create_users();
                 boolean outcome = true;
               if(u.Insert_user(user_name,user_password,user_lastname,DOB,role,status) == outcome){

               }else {


                  boolean outcome2 = false;
                  outcome = outcome2;
               }

            return outcome;
        }


}
