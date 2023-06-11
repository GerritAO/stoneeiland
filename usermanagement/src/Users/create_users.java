package Users;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class create_users extends users{



            public static boolean Insert_user(String user_name, String user_password, String user_lastname, LocalDate DOB, String role, String status){
                String url = "jdbc:mysql://localhost:3306/stone_eiland";
                String username = "root";
                String password = "";

                try(Connection conn = DriverManager.getConnection(url,username,password)){
                    String query = "INSERT INTO st_users (user_name, user_password, user_lastname, DOB, role, status) VALUES (?, ?, ?,?,?,?)";

                    PreparedStatement statement = conn.prepareStatement(query);
                    statement.setString(1, user_name);
                    statement.setString(2, user_password);
                    statement.setString(3, user_lastname);
                    statement.setDate(4, Date.valueOf(DOB));
                    statement.setString(5, role);
                    statement.setString(6, status);

                    int rowAffected = statement.executeUpdate();

                    if(rowAffected >= 1){
                        return true;
                    }else{
                        return false;
                    }


                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }


            }


}
