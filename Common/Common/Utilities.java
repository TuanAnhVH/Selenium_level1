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
        String path= System.getProperty("user.dir")+driverLocate;
        System.setProperty("webdriver.chrome.driver", path);
    }

    public static void maximizeBrowser()
    {
        Constant.WEBDRIVER.manage().window().maximize();
    }

    public static void setupBrowser(String browser){
        switch (browser) {
            case "Chrome":
                setProperty(Constant.chromeDriverLocate);
                Constant.WEBDRIVER = new ChromeDriver();
                break;
            case "FireFox":
                setProperty(Constant.geckoDriverLocate);
                Constant.WEBDRIVER = new ChromeDriver();
                break;
        }
    }
}
