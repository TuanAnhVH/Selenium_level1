package Railway;

import Common.CommonActions;
import Constant.Constant;
import org.testng.annotations.Test;
import testbase.TestBase;

public class MyTicketTest extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test
    public void TC16() {
        System.out.println("TC16 - User can cancel a ticket");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        homePage.gotoBookTicketPage();
        bookTicketPage.bookTicket("1/29/2021", "Huế", "Nha Trang", "Soft seat", 1);
        homePage.gotoMyTicketPage();

        myTicketPage.cancelTicket("Huế", "Nha Trang");

        String mesage="The ticket has not been canceled";
        CommonActions.checkControlNotExist(myTicketPage._btnCancel("Huế","Nha Trang"),mesage);
    }
}
