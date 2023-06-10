package Users;

import java.util.Date;

public class userObjClass {

    public int id;
    public String user_name;
    public String user_lastname;
    public String Role;
    public Date DOB;
    public String Status;

    public userObjClass(int id, String Voornaam, String Achternaam, String Role, Date DOB, String Status ){
        this.id = id;
        this.user_name = Voornaam;
        this.user_lastname = Achternaam;
        this.Role = Role;
        this.DOB = DOB;
        this.Status = Status;

    }

}
