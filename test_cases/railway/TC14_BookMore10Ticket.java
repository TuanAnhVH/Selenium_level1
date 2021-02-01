package railway;

import common.CommonActions;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testbase.TestBase;

import java.util.Hashtable;

public class TC14_BookMore10Ticket extends TestBase {
    RegisterPage registerPage = new RegisterPage();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    String email, password;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Go to 'Register' page.");
        homePage.gotoRegisterPage();

        System.out.println("Create a new account");
        email = CommonActions.getRandomEmail();
        password = Constant.PASSWORD;
        registerPage.register(email, password, password, Constant.PID);
    }

    @Test(dataProvider = "getDataObjects")
    public void TC14(Hashtable<String, String> data) {
        System.out.println("TC14 - User can't book more than 10 tickets");
        SoftAssert softAssert = new SoftAssert();

        System.out.println("Go to 'Login' page.");
        homePage.gotoLoginPage();

        System.out.println("Login with a valid account.");
        loginPage.login(email, password);

        System.out.println("Go to the 'Book ticket' page.");
        homePage.gotoBookTicketPage();

        System.out.println("Book 10 tickets.");
        bookTicketPage.bookTicket(data.get("departDate"), data.get("departStation"), data.get("arriveStation"), data.get("seatType"), "10");

        System.out.println("Book more tickets.");
        homePage.gotoBookTicketPage();
        bookTicketPage.bookTicket(data.get("departDate"), data.get("departStation"), data.get("arriveStation"), data.get("seatType"), data.get("ticketAmount"));

        System.out.println("Check the Book ticket message displays.");
        softAssert.assertEquals(bookTicketPage.getLblBookingError().getText(),data.get("expectedBookingMessage"));

        System.out.println("Check the 'Amount ticket' message displays.");
        softAssert.assertEquals(bookTicketPage.getLblTicketAmountError().getText(),data.get("expectedTicketAmountMessage"));

        System.out.println("Report the checking result");
        softAssert.assertAll();
    }
}
