package railway;

import constant.Constant;
import objects.Ticket;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testbase.TestBase;

import java.util.Hashtable;

public class TC15_GotoBookTicketPageFromTicketPricePage extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    TrainPriceListPage trainPriceListPage = new TrainPriceListPage();


    @Test(dataProvider = "getDataObjects")
    public void TC15(Hashtable<String, String> data) {
        System.out.println("TC15 - User can open 'Book ticket' page by click on 'Book ticket' link in 'Ticket price'");
        SoftAssert softAssert = new SoftAssert();

        System.out.println("Go to the 'Login' page.");
        homePage.gotoLoginPage();

        System.out.println("Login with a valid account.");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Go to Train price list page.");
        homePage.gotoTicketPricePage();

        System.out.println("Check price a ticket.");
        trainPriceListPage.checkPrice(data.get("departStation"), data.get("arriveStation"));

        System.out.println("Book a ticket.");
        ticketPricePage.bookTicket(data.get("seatType"));

        System.out.println("Check the depart station.");
        softAssert.assertEquals(bookTicketPage.getSelectedItem("DepartStation"),data.get("departStation"));

        System.out.println("Check the arrive station.");
        softAssert.assertEquals(bookTicketPage.getSelectedItem("ArriveStation"),data.get("arriveStation"));

        System.out.println("Check the seat type.");
        softAssert.assertEquals(bookTicketPage.getSelectedItem("SeatType"),data.get("seatType"));

        System.out.println("Report the checking result");
        softAssert.assertAll();
    }
}
