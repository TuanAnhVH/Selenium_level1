package Railway;

import Common.CommonActions;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TrainPriceListPage {

    //Elements
    protected WebElement getBtnCheckPrice(String departStation, String arriveStation){
        String path= String.format("//li[text()='%s to %s']//ancestor::tr//a[@class='BoxLink']",departStation,arriveStation);
        return CommonActions.getElement(By.xpath(path));
    }

    //Methods
    public void checkPrice(String departStation, String arriveStation){
        JavascriptExecutor executor = (JavascriptExecutor) Constant.WEBDRIVER;
        executor.executeScript("arguments[0].click();", getBtnCheckPrice(departStation, arriveStation));
    }
}
