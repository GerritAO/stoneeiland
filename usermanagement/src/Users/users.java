
package Users;

import java.util.List;

public class users {


        public static List<userObjClass> View(){
                view_users t = new view_users();
                String query = "SELECT * FROM st_users";
                List<userObjClass> userList =  t.getUsers(query);
                return userList;

        }


}
