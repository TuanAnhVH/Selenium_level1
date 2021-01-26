package common;

import constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utilities {
    public static void setProperty(String driverLocate) {

    }

    public static void maximizeBrowser()
    {
        Constant.WEBDRIVER.manage().window().maximize();
    }

    public static void setupBrowser(String browser){
        String path;
        switch (browser) {
            case "chrome":
                path= System.getProperty("user.dir")+Constant.CHROME_DRIVER_LOCATE;
                System.setProperty("webdriver.chrome.driver", path);
                Constant.WEBDRIVER = new ChromeDriver();
                break;
            case "fireFox":
                path= System.getProperty("user.dir")+Constant.GECKO_DRIVER_LOCATE;
                System.setProperty("webdriver.gecko.driver", path);
                Constant.WEBDRIVER = new FirefoxDriver();
                break;
        }
    }
}
