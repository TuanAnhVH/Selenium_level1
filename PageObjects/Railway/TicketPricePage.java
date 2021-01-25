package Railway;

import Common.CommonActions;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends GeneralPage{

    //Elements
    protected WebElement getBtnBookTicket(String seatype){
        String path= String.format("//td[text()='%s']//ancestor::tr//a[@class='BoxLink']",seatype);
        return CommonActions.getElement(By.xpath(path));
    }

    //Methods
    public void bookTicket(String seatType){
        JavascriptExecutor executor = (JavascriptExecutor)Constant.WEBDRIVER;
        executor.executeScript("arguments[0].click();", getBtnBookTicket(seatType));
    }
}
