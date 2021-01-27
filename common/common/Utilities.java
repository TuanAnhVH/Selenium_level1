package common;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Hashtable;

public class Utilities {

    public static void maximizeBrowser() {
        Constant.WEBDRIVER.manage().window().maximize();
    }

    public static void setupBrowser(String browser) {
        String path;
        switch (browser) {
            case "Chrome":
                path = System.getProperty("user.dir") + Constant.CHROME_DRIVER_LOCATE;
                System.setProperty("webdriver.chrome.driver", path);
                Constant.WEBDRIVER = new ChromeDriver();
                break;
            case "FireFox":
                path = System.getProperty("user.dir") + Constant.GECKO_DRIVER_LOCATE;
                System.setProperty("webdriver.gecko.driver", path);
                Constant.WEBDRIVER = new FirefoxDriver();
                break;
        }
    }

    public static Hashtable<String, String> getData(String key) {
        Hashtable<String, Hashtable<String, String>> list = new Hashtable<String, Hashtable<String, String>>();
        Gson gson = new Gson();
        try {
            FileReader file = new FileReader(".\\data_objects\\json_files\\Data.json");
            Type objectType = new TypeToken<Hashtable<String, Hashtable<String, String>>>() {
            }.getType();
            list = gson.fromJson(file, objectType);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Hashtable<String, String> array = list.get(key);
        return array;
    }
}
