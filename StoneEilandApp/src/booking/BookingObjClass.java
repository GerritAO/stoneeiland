package booking;

import java.util.Date;
import java.util.Locale;

public class BookingObjClass {

    public int id;
    public String klant_naam;
    public Date klant_DOB;
    public String gender;
    public String activiteit_naam;
    public String huis_naam;
    public Date datum_reservering;
    public Date datum_incheck;
    public Date datum_uitcheck;
    public String reason;
    public int overnight_Stay;
    public String status;

    public String gebruiker;

    public BookingObjClass(int Id, String klant, Date k_dob,
                           String k_gender, String Huis, Date date_servering,
                           Date date_incheck, Date date_uitcheck,
                           String Activiteiten, String Reason,
                           int overnight, String Status, String user ){

        this.id = Id;
        this.klant_naam = klant;
        this.klant_DOB = k_dob;
        this.gender = k_gender;
        this.datum_reservering = date_servering;
        this.datum_incheck = date_incheck;
        this.datum_uitcheck = date_uitcheck;
        this.huis_naam = Huis;
        this.activiteit_naam = Activiteiten;
        this.reason = Reason;
        this.overnight_Stay = overnight;
        this.status = Status;
        this.gebruiker = user;

    }

}
