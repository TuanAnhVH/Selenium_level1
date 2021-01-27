package railway;

import common.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {

    public final By lblBookingError = By.xpath("//p[@class='message error']");
    public final By lblTicketAmountError = By.xpath("//select[@name='TicketAmount']//following-sibling::label");
    protected final By cbbDepartDate = By.name("Date");
    protected final By cbbDepartFrom = By.name("DepartStation");
    protected final By cbbArriveAT = By.name("ArriveStation");
    protected final By cbbSeatType = By.name("SeatType");
    protected final By cbbTicketAmount = By.name("TicketAmount");
    protected final By btnBookTicket = By.xpath("//input[@value='Book ticket']");

    //Elements
    protected Select getCbbDepartDate() {
        return new Select(CommonActions.getElement(cbbDepartDate));
    }

    protected Select getCbbDepartFrom() {
        return new Select(CommonActions.getElement(cbbDepartFrom));
    }

    protected Select getCbbArriveAT() {
        return new Select(CommonActions.getElement(cbbArriveAT));
    }

    protected Select getCbbSeatType() {
        return new Select(CommonActions.getElement(cbbSeatType));
    }

    protected Select getCbbTicketAmount() {
        return new Select(CommonActions.getElement(cbbTicketAmount));
    }

    protected WebElement getBtnBookTicket() {
        return CommonActions.getElement(btnBookTicket);
    }

    //methods
    public void bookTicket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
        getCbbDepartDate().selectByVisibleText(departDate);
        getCbbDepartFrom().selectByVisibleText(departStation);
        CommonActions.waitForPage();
        getCbbArriveAT().selectByVisibleText(arriveStation);
        getCbbSeatType().selectByVisibleText(seatType);
        getCbbTicketAmount().selectByValue(ticketAmount);
        getBtnBookTicket().click();
    }

    public String getSelectedItem(String selectName) {
        String path = String.format("//select[@name='%s']//option[@selected='selected']", selectName);
        By selectedItem = By.xpath(path);
        return CommonActions.getElement(selectedItem).getText();
    }

}
