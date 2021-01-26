package testbase;

import objects.Ticket;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DataProviders {
    @org.testng.annotations.DataProvider(name = "getData")
    public Object[] getData(){
        ArrayList<Ticket> list = new ArrayList<>();
        Gson gson = new Gson();
        try {
            FileReader file = new FileReader(".\\external_files\\json_files\\Data.json");
            Type objectType = new TypeToken<ArrayList<Ticket>>(){}.getType();
            list = gson.fromJson(file, objectType);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list.toArray();
    }
}
