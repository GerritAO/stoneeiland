package Users;
import java.sql.*;
import java.time.LocalDate;

public class update_users extends users{

        public static void Update(int Id, String naam, String lastname, String Role, String Status ){
            String url = "jdbc:mysql://localhost:3306/stone_eiland";
            String username = "root";
            String password = "";

//            int userId = 1;
//            String newName = "John Doe";
//            String newEmail = "john.doe@example.com";

            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String selectSql = "SELECT Id, user_name, user_lastname, role,status FROM users WHERE id = ?";
                PreparedStatement selectStatement = conn.prepareStatement(selectSql);
                selectStatement.setInt(1, Id);

                ResultSet resultSet = selectStatement.executeQuery();
                if (resultSet.next()) {
                    int currentId = resultSet.getInt("Id");
                    String currentName = resultSet.getString("user_name");
                    String currentlastname = resultSet.getString("user_lastname");

                    String currentRole = resultSet.getString("role");
                    String currentStatus = resultSet.getString("status");

                    if (!naam.equals(currentName) || !lastname.equals(currentlastname)  || !currentRole.equals(Role) || !currentStatus.equals(Status)) {
                        String updateSql = "UPDATE users SET user_name = ?, user_lastname = ?, DOB = ?, role = ?, status = ? WHERE id = ?";
                        PreparedStatement updateStatement = conn.prepareStatement(updateSql);
                        updateStatement.setString(1, naam);
                        updateStatement.setString(2, lastname);

                        updateStatement.setString(4, Role);
                        updateStatement.setString(5, Status );

                        int rowsAffected = updateStatement.executeUpdate();
                        System.out.println(rowsAffected + " row(s) updated.");
                    } else {
                        System.out.println("No changes detected. Skipping update.");
                    }
                } else {
                    System.out.println("User not found.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}
