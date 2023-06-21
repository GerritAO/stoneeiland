package booking;

import db.db_connect;
import houses.housObjClass;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class booking_view extends booking_main{

    public List<BookingObjClass> getBooking(String query) {
        ResultSet result = db_connect.dbconnection(query);
        List<BookingObjClass> booking = new ArrayList<>();
        try {
            while (result.next()) {
                booking.add(new BookingObjClass(
                        result.getInt("id"),
                        result.getString("klant_naam"),
                        result.getDate("klant_DOB"),
                        result.getString("gender"),
                        result.getString("huis_naam"),
                        result.getDate("datum_incheck"),
                        result.getDate("datum_uitcheck"),

                        result.getString("activiteit_naam"),
                        result.getString("reason"),
                        result.getString("overnight_Stay"),
                        result.getString("status"),
                        result.getString("gebruiker")


                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return booking;
    }
}
