package common;

import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CommonActions {

    public static void navigateToRailway() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }

    public static void waiForControl(By locator) {
        WebDriverWait webDriverWait = new WebDriverWait(Constant.WEBDRIVER, Constant.TIME_WAIT_CONTROL);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForPage() {
        try {
            Thread.sleep(Constant.TIME_WAIT_PAGE);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static WebElement getElement(By locator) {
        waiForControl(locator);
        return Constant.WEBDRIVER.findElement(locator);
    }

    public static boolean doesControlExist(By locator) {
        waitForPage();
        if (Constant.WEBDRIVER.findElements(locator).isEmpty())
            return false;
        else
            return true;
    }

    public static void checkMessageDisplays(By locator, String expectedMessage) {
        waitForPage();
        String actualMsg = getElement(locator).getText();
        Assert.assertEquals(actualMsg, expectedMessage);
    }

    public static void enterDataToTextbox(WebElement element, String content) {
        element.clear();
        element.sendKeys(content);
    }

    public static void clickOnElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) Constant.WEBDRIVER;
        executor.executeScript("arguments[0].click();", element);
    }

    public static String getRandomEmail() {
        String time = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
        return "satt"+time+"@gmail.com";
    }

}
