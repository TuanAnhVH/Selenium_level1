package common;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
                WebDriverManager.chromedriver().clearResolutionCache().setup();
                Constant.WEBDRIVER = new ChromeDriver();
                break;
            case "FireFox":
                WebDriverManager.firefoxdriver().setup();
                Constant.WEBDRIVER = new FirefoxDriver();
                break;
        }

    }

    public static boolean doesControlExist(By locator) {
        if (Constant.WEBDRIVER.findElements(locator).isEmpty())
            return false;
        else
            return true;
    }

    public static void waiForControlVisibility(By locator) {
        WebDriverWait webDriverWait = new WebDriverWait(Constant.WEBDRIVER, Constant.TIME_WAIT_CONTROL_VISIBILITY);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waiForControlClickable(By locator) {
        WebDriverWait webDriverWait = new WebDriverWait(Constant.WEBDRIVER, Constant.TIME_WAIT_CONTROL_CLICKABLE);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static Object[] getData(String key, String dataFilePath) {
        Hashtable<String, Hashtable<String, String>[]> data = new Hashtable<String, Hashtable<String, String>[]>();
        Gson gson = new Gson();
        try {
            FileReader file = new FileReader(dataFilePath);
            Type objectType = new TypeToken<Hashtable<String, Hashtable<String, String>[]>>() {
            }.getType();
            data = gson.fromJson(file, objectType);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Hashtable<String, String>[] array = data.get(key);
        return array;
    }
}
