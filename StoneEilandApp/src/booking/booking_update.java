package booking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class booking_update extends booking_main{

    public static boolean Booking_Update(int Id, String Reason){

        String url = "jdbc:mysql://localhost:3306/stone_eiland";
        String username = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "UPDATE st_boekingen SET reason = ?, status = ? WHERE id = ?";
            String status = "Ge-annuleerd";
            PreparedStatement statementUpdate1 = conn.prepareStatement(sql);
             statementUpdate1.setString(1, Reason);
             statementUpdate1.setString(2, status);
            statementUpdate1.setInt(3, Id);
            int rowsAffected = statementUpdate1.executeUpdate();
            if (rowsAffected >= 1) {
                return true;
            } else {
                return false;
            }
        }  catch (
    SQLException e) {
        throw new RuntimeException(e);
    }

    }

    public static boolean Status_Update(int Id){
        String url = "jdbc:mysql://localhost:3306/stone_eiland";
        String username = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "UPDATE st_boekingen SET status = ?,reason = ? WHERE id = ?";
            String status = "Bevestigd";
            String reason = "Betaald";
            PreparedStatement statementUpdate1 = conn.prepareStatement(sql);
            statementUpdate1.setString(1, status);
            statementUpdate1.setString(2, reason);
            statementUpdate1.setInt(3, Id);
            int rowsAffected = statementUpdate1.executeUpdate();
            if (rowsAffected >= 1) {
                return true;
            } else {
                return false;
            }
        }  catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
