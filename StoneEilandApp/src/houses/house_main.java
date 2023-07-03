package houses;

import activiteiten.actObjeClass;
import activiteiten.activiteit_view;

import java.util.List;

public class house_main {
    public static List<housObjClass> ViewHuizen(){
        house_view t = new house_view();

        String query = "SELECT * FROM st_huizen WHERE Status LIKE 'Available' ";
        List<housObjClass> actlist =  t.getHouses(query);
        return actlist;

    }
}
