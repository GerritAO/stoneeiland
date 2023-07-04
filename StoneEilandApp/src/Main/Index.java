package Main;

import activiteiten.actObjeClass;
import booking.BookingObjClass;
import com.mysql.cj.log.Log;
import houses.housObjClass;
import Login.Login;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static Login.Login.LoginForm;
import static activiteiten.activiteit_main.ViewAct;
import static booking.booking_main.*;
import static houses.house_main.ViewHuizen;

public class Index {
    protected static String Username;
    protected String userRole;
    protected int userid;
    protected  static String dob_user;
    protected static String role = "";
    protected static int days;

    public static void main(String[] args) {

        System.out.println("Welcome bij de Stone eiland APP\n ");
        System.out.println("Login om jouw adventure te beginnen\n");
        String t = LoginForm();

        String[] split = t.split(" ", 3);
        role = split[0];
        Username = split[1];
        dob_user = split[2];
        LocalDate Date = LocalDate.now();
        Long DayDiff = ChronoUnit.YEARS.between( LocalDate.parse(dob_user), Date);
        days = Math.toIntExact(DayDiff);

        if(role.equals("Gebruiker")  | role.equals("Beheerder") ){

            menuitems();
        }
        if(!role.equals("Gebruiker")  | !role.equals("Beheerder")){
            System.out.println("Gebruiker heeft geen rechten of toegang tot het systeem, contact de beheerder");
            LoginForm();
        }
        menuitems();
        System.out.println("\n");


    }
        private static void menuitems(){
            ArrayList menuitems = new ArrayList();
            menuitems.add("0. Boeking");
            menuitems.add("1. Activiteiten");
            menuitems.add("2. Houses");
            menuitems.add("3. Logout");

            Scanner userinput = new Scanner(System.in);

            System.out.println("Kies(nummer) een optie");
            for(int i = 0; i < menuitems.size();i++){
                System.out.println(menuitems.get(i));
            }
            System.out.println("Vul je keuze in: " );
            String input = userinput.nextLine();
            int inputint = Integer.parseInt(input);

            if(inputint == 0 ){
                ArrayList submenubooking = new ArrayList();
                submenubooking.add("0. Boeking toevoegen");
                submenubooking.add("1. Boekingen bekijken");
                submenubooking.add("2. Boekingen bewerken");

                System.out.println("Kies(nummer) een optie");
                for(int i = 0; i < submenubooking.size();i++){
                    System.out.println(submenubooking.get(i));
                }


                System.out.println("Vul je keuze in: " );
                String input_keuze = userinput.nextLine();
                int inputint_keuze = Integer.parseInt(input_keuze);
                    if(days >= 19){
                        if(inputint_keuze == 0 && role.equals("Gebruiker") | role.equals("Beheerder" ) ){

                            String klant_naam=null;
                            LocalDate klant_DoB=null;
                            String gender=null;
                            String activiteit=null;
                            String huis=null;
                            LocalDate Datumreservering=null;
                            LocalDate Datumincheck=null;
                            LocalDate Datumuitcheck=null;
                            String reason=null;
                            int overnight = 0;
                            String status=null;
                            System.out.println("Welkom bij het scherm voor het invoeren van een Boeking\n");
                            klant_naam = GetKlantnaam(klant_naam);
                            klant_DoB = GetKlantDOB(klant_DoB);
                            gender = GetGender(gender);
                            Datumreservering = GetRegistrationDate(Datumreservering);
                            Datumincheck = Getincheck(Datumincheck);
                            Datumuitcheck = Getuitcheck(Datumuitcheck);
                            reason = Getreason(reason);
                            overnight = Getovernight(overnight);
                            huis=GetHuisnaam(huis);
                            activiteit = Getactiviteit(activiteit);
                            status="pending";
                            String gebruiker = Username;

                            boolean result = Insert_booking(klant_naam,klant_DoB,gender,activiteit,huis,Datumreservering,
                                    Datumincheck,Datumuitcheck,reason, overnight, status,gebruiker );

                            if (result == true){
                                System.out.println("Boeking succesvol ingevuld");
                                menuitems();
                            }
                            else{
                                System.out.println("Fout bij het invoeren");
                                menuitems();
                            }


                        }
                    }

                        else {
                            System.out.println("Gebruiker is " + days +" en is te jong om een boeking te doen");
                            menuitems();
                        }
                if(inputint_keuze == 1 && role.equals("Gebruiker") | role.equals("Beheerder")){


                    List<BookingObjClass> boekingen = ViewBoekingen(Username, role);
                    System.out.println("Een lijst van Boekingen " );
                    for (BookingObjClass boekings : boekingen) {
                        System.out.println("ID."+ boekings.id
                                + "| Klant Naam:"+ boekings.klant_naam
                                + "| Klant DOB:"+ boekings.klant_DOB
                                + "| Gender:" + boekings.gender
                                + "| Activiteit:" + boekings.activiteit_naam
                                + "| Huis : " + boekings.huis_naam
                                + "| Datum reservering:" + boekings.datum_reservering
                                + "| Datum incheck:" + boekings.datum_incheck
                                + "| Datum uitcheck:" + boekings.datum_uitcheck
                                + "| reason:" + boekings.reason
                                + "| Overnight Stay:" + boekings.overnight_Stay + "dag(en)"
                                + "| Gebruiker:" + boekings.gebruiker
                                + "| Status:" + boekings.status);
                    }
                    menuitems();
                }
                if(inputint_keuze == 2 && role.equals("Gebruiker") | role.equals("Beheerder")){

                    ArrayList submenubooking1 = new ArrayList();
                    submenubooking1.add("0. Boeking Annuleren");
                    submenubooking1.add("1. Boekingen Bevestigen");

                    System.out.println("Kies(nummer) een optie");
                    for(int i = 0; i < submenubooking1.size();i++){
                        System.out.println(submenubooking1.get(i));
                    }


                    System.out.println("Vul je keuze in: " );
                    String in_bewerken= userinput.nextLine();
                    int input_bewerken = Integer.parseInt(in_bewerken);
                    if(input_bewerken == 0 && role.equals("Gebruiker") | role.equals("Beheerder") ){
                        List<BookingObjClass> boekingen = ViewBoekingen(Username, role);
                        System.out.println("Een lijst van Boekingen " );
                        for (BookingObjClass boekings : boekingen) {
                            System.out.println("ID."+ boekings.id
                                    + "| Klant Naam:"+ boekings.klant_naam
                                    + "| Klant DOB:"+ boekings.klant_DOB
                                    + "| Gender:" + boekings.gender
                                    + "| Activiteit:" + boekings.activiteit_naam
                                    + "| Huis : " + boekings.huis_naam
                                    + "| Datum reservering:" + boekings.datum_reservering
                                    + "| Datum incheck:" + boekings.datum_incheck
                                    + "| Datum uitcheck:" + boekings.datum_uitcheck
                                    + "| reason:" + boekings.reason
                                    + "| Overnight Stay:" + boekings.overnight_Stay + "dag(en)"
                                    + "| Gebruiker:" + boekings.gebruiker
                                    + "| Status:" + boekings.status);
                        }
                        System.out.println("Welke boekingen wil jij bewerken?\n");
                        int Id_booking = 0;
                        String reasoning = null;
                        Id_booking =GetId(Id_booking);
                        reasoning = UpdateReason(reasoning);

                        boolean result = Update_Reason(Id_booking, reasoning);

                        if (result == true){
                            System.out.println("Boeking succesvol upgedate en geannuleerd");
                            menuitems();
                        }
                        else{
                            System.out.println("Fout bij het updaten en annuleren");
                            menuitems();
                        }

                    }
                    if(input_bewerken == 1 && !role.equals("Gebruiker") | role.equals("Beheerder")){
                        List<BookingObjClass> boekingen = ViewBoekingen(Username, role);
                        System.out.println("Een lijst van Boekingen " );
                        for (BookingObjClass boekings : boekingen) {
                            System.out.println("ID."+ boekings.id
                                    + "| Klant Naam:"+ boekings.klant_naam
                                    + "| Klant DOB:"+ boekings.klant_DOB
                                    + "| Gender:" + boekings.gender
                                    + "| Activiteit:" + boekings.activiteit_naam
                                    + "| Huis : " + boekings.huis_naam
                                    + "| Datum reservering:" + boekings.datum_reservering
                                    + "| Datum incheck:" + boekings.datum_incheck
                                    + "| Datum uitcheck:" + boekings.datum_uitcheck
                                    + "| reason:" + boekings.reason
                                    + "| Overnight Stay:" + boekings.overnight_Stay + "dag(en)"
                                    + "| Gebruiker:" + boekings.gebruiker
                                    + "| Status:" + boekings.status);
                        }
                        System.out.println("Welke boekingen wil jij bevestigen?\n");
                        int Id_booking = 0;
                        Id_booking =GetId(Id_booking);
                        boolean result = Update_Status(Id_booking);

                        if (result == true){
                            System.out.println("Boeking succesvol upgedate en bevestigd");
                            menuitems();
                        }
                        else{
                            System.out.println("Fout bij het updaten en annuleren");
                            menuitems();
                        }

                    }

                }
                else {
                    System.out.println("Gebruiker " + Username  + " Heeft geen toegang");
                    menuitems();
                }


            }

            if(inputint == 1){
                List<actObjeClass> actvititeiten = ViewAct();
                System.out.println("Een lijst van de Activiteiten " );
                for (actObjeClass actvititeit : actvititeiten) {
                    System.out.println("ID."+actvititeit.id + "  Activiteit Naam:" + actvititeit.act_name+ ", Activiteit Price in $: " + actvititeit.act_price+ " Status:"+ actvititeit.status+ "\n");
                }
                menuitems();

            }
            if(inputint == 2){
                List<housObjClass> huizen = ViewHuizen();
                System.out.println("Een lijst van Huizen " );
                for (housObjClass huis : huizen) {
                    System.out.println("ID."+ huis.id + "| Naam:" + huis.house_name+ "| Huis Price in $: " + huis.house_price+ "| Status:"+ huis.Status+ "\n");
                }
                menuitems();
            }
            if(inputint == 3){
                System.out.println("U bent succesvol uitgelogd\n");
                System.out.println("Welcome bij de Stone eiland APP\n ");
                System.out.println("Login om jouw adventure te beginnen\n");
                 Username=null;
                 dob_user=null;
                 role = null;
                LoginForm();
            }
        }


    private static int GetId(int ID){

        System.out.println("Select welke ID van boeking dat u wilt bewerken: ");
        ID = getUserIntInput();
        return ID;
    }

    private static String GetKlantnaam(String klant){
        System.out.println("Klantnaam: ");
        klant = getUserStringInput();
        return klant;
    }

    private static LocalDate GetKlantDOB(LocalDate KDOB){
        System.out.println("DOB (yyyy-mm-dd): ");
        KDOB = getUserDateInput();
        return KDOB;
    }
    private static String GetGender(String Gender){
        System.out.println("Gender: ");
        Gender = getUserStringInput();
        return Gender;
    }
    private static String Getactiviteit(String activiteit){
        List<actObjeClass> actvititeiten = ViewAct();
        System.out.println("Een lijst van de Activiteiten  available" );
        for (actObjeClass actvititeit : actvititeiten) {
            System.out.println("ID."+actvititeit.id + "  Activiteit Naam:" + actvititeit.act_name+ ", Activiteit Price in $: " + actvititeit.act_price+ " Status:"+ actvititeit.status+ "\n");
        }
        System.out.println("Activiteit: ");
        activiteit = getUserStringInput();
        return activiteit;
    }
    private static String GetHuisnaam(String Huis){
        List<housObjClass> huizen = ViewHuizen();
        System.out.println("Een lijst van Huizen available " );
        for (housObjClass huis : huizen) {
            System.out.println("ID."+ huis.id + "| Naam:" + huis.house_name+ "| Huis Price in $: " + huis.house_price+ "| Status:"+ huis.Status+ "\n");
        }
        System.out.println("Huis: ");
        Huis = getUserStringInput();
        return Huis;
    }

    private static LocalDate GetRegistrationDate(LocalDate reg_date){
        System.out.println("Registratie Datum (yyyy-mm-dd): ");
        reg_date = getUserDateInput();
        return reg_date;
    }
    private static LocalDate Getincheck(LocalDate incheck){
        System.out.println("Incheck Datum (yyyy-mm-dd): ");
        incheck = getUserDateInput();
        return incheck;
    }
    private static LocalDate Getuitcheck(LocalDate uitcheck){
        System.out.println("Uitcheck Datum (yyyy-mm-dd): ");
        uitcheck = getUserDateInput();
        return uitcheck;
    }
    private static String Getreason(String reason){
        System.out.println("Reason: ");
        reason = getUserStringInput();
        return reason;
    }

    private static int Getovernight(int  overnightstay){
        System.out.println("Overnight(yes/No): ");
        overnightstay = getUserIntInput();
        return overnightstay;
    }
    private static String UpdateReason(String Reason){
        System.out.println("Geef een reden aan waarom deze boeking word geannuleerd: ");
        Reason = getUserStringInput();
        return Reason;
    }


    private static String GetRole(String role){
        System.out.println("role: ");
        role = getUserStringInput();
        return role;
    }
    private static LocalDate GetDOB(LocalDate DOB){
        System.out.println("DOB (yyyy-mm-dd): ");
        DOB = getUserDateInput();
        return DOB;
    }

    public static int getUserIntInput() {
        Scanner userIntInput = new Scanner(System.in);
        return userIntInput.nextInt();
    }
    public static String getUserStringInput() {
        Scanner userStringInput = new Scanner(System.in);
        return userStringInput.nextLine();
    }
    public static LocalDate getUserDateInput() {
        Scanner userDateInput = new Scanner(System.in);
        String userInput = userDateInput.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        return LocalDate.parse(userInput, formatter);
    }
    }



