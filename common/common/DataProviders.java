package common;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;

public class DataProviders {
    @DataProvider(name = "getData")
    public Object[] getData(Method method) {
        ArrayList<Hashtable<String, String>> list = new ArrayList<>();
        list.add(Utilities.getData(method.getName()));
        return list.toArray();
    }
}
