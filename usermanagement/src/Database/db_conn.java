package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class db_conn {

        public static ResultSet dbconnection(String query){
            String url = "jdbc:mysql://localhost:3306/stone_eiland";
            String username = "root";
            String password = "";
            ResultSet resultSet;
            try {
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();
                resultSet = statement.executeQuery(query);
                //System.out.println("succes");
                return resultSet;

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return  null;
        }
    }

