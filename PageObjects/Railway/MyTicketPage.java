package Railway;

import Common.CommonActions;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MyTicketPage {
    //Locator
    protected By _btnCancel(String departStation,String arriveStation){
        String path= String.format("//td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td//input[@value='Cancel']",
                departStation,arriveStation);
        return By.xpath(path);
    }

    //Elements
    protected WebElement getBtnCancel(String departStation,String arriveStation){
       return CommonActions.getElement(_btnCancel(departStation, arriveStation));
    }

    //Methods

    public void cancelTicket(String departStation,String arriveStation){
        JavascriptExecutor executor = (JavascriptExecutor) Constant.WEBDRIVER;
        executor.executeScript("arguments[0].click();",getBtnCancel(departStation,arriveStation));
    }

}
