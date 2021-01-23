package Railway;

import Common.CommonActions;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {

    protected final By _cbbDepartDate = By.name("Date");
    protected final By _cbbDepartFrom = By.name("DepartStation");
    protected final By _cbbArriveAT = By.name("ArriveStation");
    protected final By _cbbSeatType = By.name("SeatType");
    protected final By _cbbTicketAmount = By.name("TicketAmount");
    protected final By _btnBookTicket = By.xpath("//input[@type='submit']");

    //Elements
    protected Select getCbbDepartDate() {
        return  new Select(CommonActions.getElement(_cbbDepartDate));
    }

    protected Select getCbbDepartFrom() {
        return new Select(CommonActions.getElement(_cbbDepartFrom));
    }

    protected Select getCbbArriveAT() {
        return new Select(CommonActions.getElement(_cbbArriveAT));
    }

    protected Select getCbbSeatType() {
        return new Select(CommonActions.getElement(_cbbSeatType));
    }

    protected Select getCbbTicketAmount() {
        return new Select(CommonActions.getElement(_cbbTicketAmount));
    }

    protected WebElement getBtnBookTicket() {
        return CommonActions.getElement(_btnBookTicket);
    }

    //methods
     public void bookTicket(String departDate, String departFrom, String arriveAt, String seatType, int ticketAmount){
        getCbbDepartDate().selectByVisibleText(departDate);
        getCbbDepartFrom().selectByVisibleText(departFrom);
        getCbbArriveAT().selectByVisibleText(arriveAt);
        getCbbSeatType().selectByVisibleText(seatType);
        getCbbTicketAmount().selectByValue(ticketAmount+"");
        getBtnBookTicket().click();
     }

}
