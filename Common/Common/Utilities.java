package Common;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
            case "Chrome":
                path= System.getProperty("user.dir")+Constant.CHROME_DRIVER_LOCATE;
                System.setProperty("webdriver.chrome.driver", path);
                Constant.WEBDRIVER = new ChromeDriver();
                break;
            case "FireFox":
                path= System.getProperty("user.dir")+Constant.GECKO_DRIVER_LOCATE;
                System.setProperty("webdriver.gecko.driver", path);
                Constant.WEBDRIVER = new FirefoxDriver();
                break;
        }
    }
}
