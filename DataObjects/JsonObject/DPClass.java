package JsonObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DPClass {
    @DataProvider(name = "Ticket")
    public Object[] getTicket(){
        ArrayList<Ticket> list = new ArrayList<>();
        Gson gson = new Gson();

        try {
            FileReader file = new FileReader(".\\DataObjects\\JsonFiles\\Tickets.json");

            Type objectType = new TypeToken<ArrayList<Ticket>>(){}.getType();
            list = gson.fromJson(file, objectType);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list.toArray();
    }
}
