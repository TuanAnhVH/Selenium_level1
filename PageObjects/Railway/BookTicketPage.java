package Railway;

import Common.CommonActions;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class BookTicketPage extends GeneralPage {

    public final By _cbbDepartDate = By.name("Date");
    public final By _cbbDepartFrom = By.name("DepartStation");
    public final By _cbbArriveAT = By.name("ArriveStation");
    public final By _cbbSeatType = By.name("SeatType");
    public final By _cbbTicketAmount = By.name("TicketAmount");
    public final By _btnBookTicket = By.xpath("//input[@value='Book ticket']");
    public final By _lblBookingError = By.xpath("//p[@class='message error']");
    public final By _lblTicketAmountError = By.xpath("//select[@name='TicketAmount']//following-sibling::label");

    //Elements
    public Select getCbbDepartDate() {
        return  new Select(CommonActions.getElement(_cbbDepartDate));
    }

    public Select getCbbDepartFrom() {
        return new Select(CommonActions.getElement(_cbbDepartFrom));
    }

    public Select getCbbArriveAT() {
        return new Select(CommonActions.getElement(_cbbArriveAT));
    }

    public Select getCbbSeatType() { return new Select(CommonActions.getElement(_cbbSeatType));
    }

    protected Select getCbbTicketAmount() {
        return new Select(CommonActions.getElement(_cbbTicketAmount));
    }

    protected WebElement getBtnBookTicket() {
        return CommonActions.getElement(_btnBookTicket);
    }

    //methods
     public void bookTicket(String departDate, String departStation, String arriveStation, String seatType, int ticketAmount){
        getCbbDepartDate().selectByVisibleText(departDate);
        getCbbDepartFrom().selectByVisibleText(departStation);
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             System.out.println(e);
         }
        getCbbArriveAT().selectByVisibleText(arriveStation);
        getCbbSeatType().selectByVisibleText(seatType);
        getCbbTicketAmount().selectByValue(ticketAmount+"");
        getBtnBookTicket().submit();
//        getBtnBookTicket().click();
     }

}
