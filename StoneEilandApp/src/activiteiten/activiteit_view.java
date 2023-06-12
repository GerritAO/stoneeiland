package activiteiten;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import db.db_connect;

public class activiteit_view extends activiteit_main {

    public List<actObjeClass> getActiviteiten(String query) {
        ResultSet result = db_connect.dbconnection(query);
        List<actObjeClass> activiteiten = new ArrayList<>();
        try {
            while (result.next()) {
                activiteiten.add(new actObjeClass(
                        result.getInt("id"),
                        result.getString("act_name"),
                        result.getFloat("act_price"),
                        result.getString("status")

                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return activiteiten;
    }
}
