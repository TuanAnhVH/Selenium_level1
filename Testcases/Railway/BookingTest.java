package Railway;

import Common.CommonActions;
import Constant.Constant;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import testbase.TestBase;

public class BookingTest extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test
    public void TC14() {
        System.out.println("TC14 - User can't book more than 10 tickets");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);
        homePage.gotoBookTicketPage();
        bookTicketPage.bookTicket("1/29/2021","Huế", "Nha Trang", "Soft seat", 10);
        homePage.gotoBookTicketPage();
        bookTicketPage.bookTicket("1/29/2021","Huế", "Nha Trang", "Soft seat", 1);

        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        CommonActions.checkMessageDisplays(bookTicketPage._lblBookingError,expectedMsg);

        expectedMsg = "You have booked 10 tickets. You can book no more.";
        CommonActions.checkMessageDisplays(bookTicketPage._lblTicketAmountError,expectedMsg);
    }


}
