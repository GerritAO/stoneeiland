package db;

import java.sql.*;

public class db_connect {

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
