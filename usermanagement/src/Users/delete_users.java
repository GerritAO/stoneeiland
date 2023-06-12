package Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class delete_users extends users{

    public static boolean Delete_user(int id){
        String url = "jdbc:mysql://localhost:3306/stone_eiland";
        String username = "root";
        String password = "";
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "DELETE FROM st_users WHERE id = ?" ;

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);  // Set the value for the id column to identify the record

            int rowsAffected = statement.executeUpdate();

            if(rowsAffected >= 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
