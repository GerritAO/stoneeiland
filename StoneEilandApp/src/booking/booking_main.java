package booking;

import houses.housObjClass;
import houses.house_view;

import java.time.LocalDate;
import java.util.List;

public class booking_main {
    public static List<BookingObjClass> ViewBoekingen(String user, String Role){
        booking_view t = new booking_view();
        String query="";
        if(Role.equals("Gebruiker")){

             query = "SELECT * FROM st_boekingen WHERE gebruiker LIKE " + "'" + user +"'" ;
        }
        if(Role.equals("Beheerder")){

            query = "SELECT * FROM st_boekingen ";
        }


        List<BookingObjClass> booking =  t.getBooking(query);
        return booking;

    }

    public static boolean Insert_booking(String klant_naam,LocalDate klant_DOB,
                                         String gender, String activiteit_naam ,
                                         String huis_naam,LocalDate datum_reservering,
                                         LocalDate datum_incheck, LocalDate datum_uitcheck,
                                         String reason, int overnight_stay,
                                         String status, String gebruiker){
        Booking_create u = new Booking_create();
        boolean outcome = true;
        if(u.Insert_boeking(klant_naam,klant_DOB,gender,activiteit_naam,huis_naam,datum_reservering,
                            datum_incheck,datum_uitcheck,reason, overnight_stay, status,gebruiker  ) == outcome){

        }else {


            boolean outcome2 = false;
            outcome = outcome2;
        }

        return outcome;
    }

    public static boolean Update_Reason(int Id_booking, String reason){
            booking_update b_u = new booking_update();
            boolean outcome = true;
            if(b_u.Booking_Update(Id_booking, reason) == outcome){

            }else {


                boolean outcome2 = false;
                outcome = outcome2;
            }

        return outcome;
    }

    public static boolean Update_Status(int Id_booking){
        booking_update b_u = new booking_update();
        boolean outcome = true;
        if(b_u.Status_Update(Id_booking) == outcome){

        }else {


            boolean outcome2 = false;
            outcome = outcome2;
        }

        return outcome;
    }
}
