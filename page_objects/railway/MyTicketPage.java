package railway;

import common.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage{
    //Locator
    protected By _btnCancel(String departStation, String arriveStation) {
        String path = String.format("//td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td//input[@value='Cancel']",
                departStation, arriveStation);
        return By.xpath(path);
    }

    //Elements
    protected WebElement getBtnCancel(String departStation, String arriveStation) {
        return this.getElement(_btnCancel(departStation, arriveStation));
    }

    //Methods
    public void cancelTicket(String departStation, String arriveStation) {
        this.clickOnElement(getBtnCancel(departStation, arriveStation));
    }

}
