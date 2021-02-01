package railway;

import common.CommonActions;
import common.Utilities;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testbase.TestBase;

import java.util.Hashtable;

public class TC16_CancelTicket extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();
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
    public void TC16(Hashtable<String, String> data) {
        System.out.println("TC16 - User can cancel a ticket.");

        System.out.println("Go to Login page.");
        homePage.gotoLoginPage();

        System.out.println("Login with a valid account.");
        loginPage.login(email, password);

        System.out.println("Go to 'Book ticket' page.");
        homePage.gotoBookTicketPage();

        System.out.println("Book any ticket.");
        bookTicketPage.bookTicket(data.get("departDate"), data.get("departStation"), data.get("arriveStation"), data.get("seatType"), data.get("ticketAmount"));

        System.out.println("Go to 'My ticket' page");
        homePage.gotoMyTicketPage();

        System.out.println("Cancel any ticket.");
        myTicketPage.cancelTicket(data.get("departStation"), data.get("arriveStation"));

        System.out.println("confirm canceling.");
        Constant.WEBDRIVER.switchTo().alert().accept();

        System.out.println("Check the canceled ticket is disappeared.");
        homePage.gotoMyTicketPage();
        boolean checkExist = doesControlExist(myTicketPage._btnCancel(data.get("departStation"), data.get("arriveStation")));
        Assert.assertFalse(checkExist, "The ticket has not been canceled");
    }
}
