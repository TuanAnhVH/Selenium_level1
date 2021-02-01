package railway;

import common.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends GeneralPage{

    //Elements
    protected WebElement getBtnBookTicket(String seatype){
        String path= String.format("//td[text()='%s']//ancestor::tr//a[@class='BoxLink']",seatype);
        return getElement(By.xpath(path));
    }

    //Methods
    public void bookTicket(String seatType){
        this.clickOnElement(getBtnBookTicket(seatType));
    }
}
