package Common;

import Constant.Constant;
import Railway.HomePage;
import Railway.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.LocalTime;
import java.util.Calendar;

public class CommonActions {

    public static void navigateToRailway(){
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }

    public static void waiForControl(By locator)
    {
        WebDriverWait webDriverWait = new WebDriverWait(Constant.WEBDRIVER,Constant.TIME_WAIT_CONTROL);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waiForControl(By locator, int time)
    {
        WebDriverWait webDriverWait = new WebDriverWait(Constant.WEBDRIVER,time);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement getElement(By locator){
        waiForControl(locator);
        return Constant.WEBDRIVER.findElement(locator);
    }

    public static void checkControlExist(By locator,String message) {
        waiForControl(locator);
        Assert.assertTrue(Constant.WEBDRIVER.findElement(locator).isDisplayed(),message);
    }

    public static void checkMessageDisplays(By locator, String expectedMessage){
        String actualMsg = getElement(locator).getText();
        Assert.assertEquals(actualMsg, expectedMessage);
    }

    public static void enterDataToTextbox(WebElement element, String content){
        element.clear();
        element.sendKeys(content);
    }

    public static String curentTime(){
        Calendar calendar = Calendar.getInstance();
        String year = calendar.get(Calendar.YEAR)+"";
        String month = calendar.get(Calendar.MONTH)+"";;
        String date = calendar.get(Calendar.DATE)+"";;
        String hour = calendar.get(Calendar.HOUR)+"";
        String minute = calendar.get(Calendar.MINUTE)+"";
        String second = calendar.get(Calendar.SECOND)+"";
        return year+month+date+hour+minute+second;
    }
}