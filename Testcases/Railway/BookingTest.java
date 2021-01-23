package Railway;

import Common.CommonActions;
import Constant.Constant;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import testbase.TestBase;

public class BookingTest extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("Pre-condition");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);
    }

    @Test
    public void TC14() {
        System.out.println("TC14 - User can't book more than 10 tickets");
        homePage.gotoBookTicketPage();
        bookTicketPage.bookTicket("1/27/2021","Phan Thiết", "Nha Trang", "Soft seat", 2);
    }
}
