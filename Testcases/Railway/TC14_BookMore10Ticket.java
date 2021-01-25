package Railway;

import Common.CommonActions;
import Constant.Constant;
import org.testng.annotations.Test;
import testbase.TestBase;

public class TC14_BookMore10Ticket extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test
    public void TC14() {
        System.out.println("TC14 - User can't book more than 10 tickets");

        System.out.println("Go to 'Login' page.");
        homePage.gotoLoginPage();

        System.out.println("Login with a valid account.");
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        System.out.println("Go to the 'Book ticket' page.");
        homePage.gotoBookTicketPage();

        System.out.println("Book 10 tickets.");
        bookTicketPage.bookTicket("1/29/2021","Huế", "Nha Trang", "Soft seat", 10);

        homePage.gotoBookTicketPage();

        System.out.println("Book more tickets.");
        bookTicketPage.bookTicket("1/29/2021","Huế", "Nha Trang", "Soft seat", 1);

        System.out.println("Check the Book ticket message displays.");
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        CommonActions.checkMessageDisplays(bookTicketPage._lblBookingError,expectedMsg);

        System.out.println("Check the 'Amount ticket' message displays.");
        expectedMsg = "You have booked 10 tickets. You can book no more.";
        CommonActions.checkMessageDisplays(bookTicketPage._lblTicketAmountError,expectedMsg);
    }
}
