package activiteiten;

import java.util.List;

public class activiteit_main {

    public static List<actObjeClass> ViewAct(){
        activiteit_view t = new activiteit_view();

        String query = "SELECT * FROM st_activiteiten";
        List<actObjeClass> actlist =  t.getActiviteiten(query);
        return actlist;

    }
}
