package booking;

import java.sql.*;
import java.time.LocalDate;

public class Booking_create  extends booking_main{


    public static boolean Insert_boeking(String klant_naam,LocalDate klant_DOB,
                                      String gender, String activiteit_naam ,
                                      String huis_naam,LocalDate datum_reservering,
                                      LocalDate datum_incheck, LocalDate datum_uitcheck,
                                      String reason, String overnight_stay,
                                      String status, String gebruiker) {
        String url = "jdbc:mysql://localhost:3306/stone_eiland";
        String username = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO st_boekingen (klant_naam, klant_DOB, gender, activiteit_naam, huis_naam, datum_reservering,datum_incheck, datum_uitcheck, reason, overnight_stay, status, gebruiker) VALUES (?, ?, ?,? ,? ,?, ? ,? ,?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, klant_naam);
            statement.setDate(2, Date.valueOf(klant_DOB));
            statement.setString(3, gender);
            statement.setString(4, activiteit_naam);
            statement.setString(5, huis_naam);
            statement.setDate(6, Date.valueOf(datum_reservering));
            statement.setDate(7, Date.valueOf(datum_incheck));
            statement.setDate(8, Date.valueOf(datum_uitcheck));
            statement.setString(9, reason);
            statement.setString(10, overnight_stay);
            statement.setString(11, status);
            statement.setString(12, gebruiker);

            int rowAffected = statement.executeUpdate();

            if (rowAffected >= 1) {
                return true;
            } else {
                return false;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
