package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testbase.TestBase;

public class TC15_GotoBookTicketPageFromTicketPricePage extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    TrainPriceListPage trainPriceListPage = new TrainPriceListPage();


    @Test
    public void TC15() {
        System.out.println("TC15 - User can open 'Book ticket' page by click on 'Book ticket' link in 'Ticket price'");
        SoftAssert softAssert = new SoftAssert();

        String departStation = "Đà Nẵng";
        String arriveStation = "Quảng Ngãi";
        String seatType = "Soft seat";

        System.out.println("Go to the 'Login' page.");
        homePage.gotoLoginPage();

        System.out.println("Login with a valid account.");
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        System.out.println("Go to Train price list page.");
        homePage.gotoTicketPricePage();

        System.out.println("Check price a ticket.");
        trainPriceListPage.checkPrice(departStation, arriveStation);

        System.out.println("Book a ticket.");
        ticketPricePage.bookTicket(seatType);

        System.out.println("Check the depart station.");
        softAssert.assertEquals(departStation,bookTicketPage.getSelectedItem("DepartStation"));

        System.out.println("Check the arrive station.");
        softAssert.assertEquals(arriveStation,bookTicketPage.getSelectedItem("ArriveStation"));

        System.out.println("Check the seat type.");
        softAssert.assertEquals(seatType,bookTicketPage.getSelectedItem("SeatType"));

        softAssert.assertAll();
    }
}
