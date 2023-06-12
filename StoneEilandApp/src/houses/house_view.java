package houses;

import activiteiten.actObjeClass;
import db.db_connect;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class house_view extends house_main{

    public List<housObjClass> getHouses(String query) {
        ResultSet result = db_connect.dbconnection(query);
        List<housObjClass> houses = new ArrayList<>();
        try {
            while (result.next()) {
                houses.add(new housObjClass(
                        result.getInt("id"),
                        result.getString("house_name"),
                        result.getFloat("house_price"),
                        result.getString("status")

                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return houses;
    }
}
