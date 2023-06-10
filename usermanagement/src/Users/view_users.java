package Users;

import Database.db_conn;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class view_users extends users {
    public List<userObjClass> getUsers(String query) {
        //String query = "SELECT * FROM st_users";
        ResultSet result = db_conn.dbconnection(query);
        List<userObjClass> users = new ArrayList<>();
        try {
            while (result.next()) {
                users.add(new userObjClass(
                        result.getInt("id"),
                        result.getString("user_name"),
                        result.getString("user_lastname"),
                        result.getString("Role"),
                        result.getDate("DOB"),
                        result.getString("Status")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
