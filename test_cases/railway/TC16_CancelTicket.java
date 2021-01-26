package railway;

import common.CommonActions;
import constant.Constant;
import objects.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.DataProviders;
import testbase.TestBase;

public class TC16_CancelTicket extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test(dataProvider = "getData",dataProviderClass = DataProviders.class)
    public void TC16(Ticket ticket) {
        System.out.println("TC16 - User can cancel a ticket.");

        System.out.println("Go to Login page.");
        homePage.gotoLoginPage();

        System.out.println("Login with a valid account.");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Go to 'Book ticket' page.");
        homePage.gotoBookTicketPage();

        System.out.println("Book any ticket.");
        bookTicketPage.bookTicket(ticket.departDate, ticket.departStation, ticket.arriveStation,ticket.seatType,ticket.ticketAmount);

        System.out.println("Go to 'My ticket' page");
        homePage.gotoMyTicketPage();

        System.out.println("Cancel any ticket.");
        myTicketPage.cancelTicket(ticket.departStation, ticket.arriveStation);

        System.out.println("confirm canceling.");
        Constant.WEBDRIVER.switchTo().alert().accept();

        System.out.println("Check the canceled ticket is disappeared.");
        boolean checkExist = CommonActions.doesControlExist(myTicketPage._btnCancel(ticket.departStation,ticket.arriveStation));
        Assert.assertFalse(checkExist,"The ticket has not been canceled");
    }
}
