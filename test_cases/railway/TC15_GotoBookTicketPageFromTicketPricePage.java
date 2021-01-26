package railway;

import constant.Constant;
import objects.Ticket;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testbase.DataProviders;
import testbase.TestBase;

public class TC15_GotoBookTicketPageFromTicketPricePage extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    TrainPriceListPage trainPriceListPage = new TrainPriceListPage();


    @Test(dataProvider = "getData",dataProviderClass = DataProviders.class)
    public void TC15(Ticket ticket) {
        System.out.println("TC15 - User can open 'Book ticket' page by click on 'Book ticket' link in 'Ticket price'");
        SoftAssert softAssert = new SoftAssert();

        System.out.println("Go to the 'Login' page.");
        homePage.gotoLoginPage();

        System.out.println("Login with a valid account.");
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        System.out.println("Go to Train price list page.");
        homePage.gotoTicketPricePage();

        System.out.println("Check price a ticket.");
        trainPriceListPage.checkPrice(ticket.departStation, ticket.arriveStation);

        System.out.println("Book a ticket.");
        ticketPricePage.bookTicket(ticket.seatType);

        System.out.println("Check the depart station.");
        softAssert.assertEquals(ticket.departStation,bookTicketPage.getSelectedItem("DepartStation"));

        System.out.println("Check the arrive station.");
        softAssert.assertEquals(ticket.arriveStation,bookTicketPage.getSelectedItem("ArriveStation"));

        System.out.println("Check the seat type.");
        softAssert.assertEquals(ticket.seatType,bookTicketPage.getSelectedItem("SeatType"));

        softAssert.assertAll();
    }
}
