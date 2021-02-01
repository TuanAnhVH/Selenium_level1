package railway;


import common.CommonActions;
import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {

    protected final By lblBookingError = By.xpath("//p[@class='message error']");
    protected final By lblTicketAmountError = By.xpath("//select[@name='TicketAmount']//following-sibling::label");
    protected final By cbbDepartDate = By.name("Date");
    protected final By cbbDepartStation = By.name("DepartStation");
    protected final By cbbArriveStation = By.name("ArriveStation");
    protected final By cbbSeatType = By.name("SeatType");
    protected final By cbbTicketAmount = By.name("TicketAmount");
    protected final By btnBookTicket = By.xpath("//input[@value='Book ticket']");

    //Elements
    protected Select getCbbDepartDate() {
        return new Select(CommonActions.getElement(cbbDepartDate));
    }

    protected Select getCbbDepartStation() {
        return new Select(CommonActions.getElement(cbbDepartStation));
    }

    protected Select getCbbArriveStation() { return new Select(CommonActions.getElement(cbbArriveStation)); }

    protected Select getCbbSeatType() {
        return new Select(CommonActions.getElement(cbbSeatType));
    }

    protected Select getCbbTicketAmount() {
        return new Select(CommonActions.getElement(cbbTicketAmount));
    }

    protected WebElement getBtnBookTicket() {
        return this.getElement(btnBookTicket);
    }

    protected WebElement getLblBookingError() {
        return this.getElement(lblBookingError);
    }

    protected WebElement getLblTicketAmountError() {
        return this.getElement(lblTicketAmountError);
    }

    //methods
    public String getSelectedItem(String selectName) {
        String path = String.format("//select[@name='%s']//option[@selected='selected']", selectName);
        By selectedItem = By.xpath(path);
        return this.getElement(selectedItem).getText();
    }

    public void selectItem(Select sellect, String itemName){
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", sellect);
        sellect.selectByVisibleText(itemName);
    }

    public void bookTicket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
        selectItem(getCbbDepartDate(),departDate);
        selectItem(getCbbDepartStation(),departStation);
        selectItem(getCbbSeatType(),seatType);
        selectItem(getCbbTicketAmount(),ticketAmount);
        waiForControlClickable(cbbArriveStation);
        selectItem(getCbbArriveStation(),arriveStation);
        clickOnElement(getBtnBookTicket());
    }
}
