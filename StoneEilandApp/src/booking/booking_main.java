package booking;

import houses.housObjClass;
import houses.house_view;

import java.util.List;

public class booking_main {
    public static List<BookingObjClass> ViewBoekingen(){
        booking_view t = new booking_view();

        String query = "SELECT * FROM st_boekingen" ;
        List<BookingObjClass> booking =  t.getBooking(query);
        return booking;

    }
}
