package Railway;

import Common.CommonActions;
import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.TestBase;

public class TC16_CancelTicket extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test
    public void TC16() {
        System.out.println("TC16 - User can cancel a ticket.");

        String departDate= "1/29/2021";
        String departStation = "Đà Nẵng";
        String arriveStation = "Quảng Ngãi";
        String seatType = "Soft seat";
        int ticketAmount = 1;

        System.out.println("Go to Login page.");
        homePage.gotoLoginPage();

        System.out.println("Login with a valid account.");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Go to 'Book ticket' page.");
        homePage.gotoBookTicketPage();

        System.out.println("Book any ticket.");
        bookTicketPage.bookTicket(departDate, departStation, arriveStation, seatType, ticketAmount);

        System.out.println("Go to 'My ticket' page");
        homePage.gotoMyTicketPage();

        System.out.println("Cancel any ticket.");
        myTicketPage.cancelTicket(departStation, arriveStation);

        System.out.println("confirm canceling.");
        Constant.WEBDRIVER.switchTo().alert().accept();

        System.out.println("Check the canceled ticket is disappeared.");
        boolean checkExist = CommonActions.doesControlExist(myTicketPage._btnCancel(departStation,arriveStation));
        Assert.assertFalse(checkExist,"The ticket has not been canceled");
    }
}
