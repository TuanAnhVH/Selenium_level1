package common;

import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CommonActions extends Utilities{

    public static void navigateToRailway() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }

    public static WebElement getElement(By locator) {
        waiForControlVisibility(locator);
        return Constant.WEBDRIVER.findElement(locator);
    }

    public static void enterDataToTextbox(WebElement element, String content) {
        scrollToControl(element);
        element.clear();
        element.sendKeys(content);
    }

    public static  void scrollToControl(WebElement webElement){
        JavascriptExecutor executor = (JavascriptExecutor) Constant.WEBDRIVER;
        executor.executeScript("arguments[0].scrollIntoView(true);", webElement);

    }

    public static void clickOnElement(WebElement element) {
        scrollToControl(element);
        element.click();
    }

    public static String getRandomEmail() {
        String time = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
        return "satt"+time+"@gmail.com";
    }

}
