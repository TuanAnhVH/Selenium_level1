package Railway;

import Common.CommonActions;
import Constant.Constant;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import testbase.TestBase;

public class TicketPriceTest extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    TrainPriceListPage trainPriceListPage = new TrainPriceListPage();

    @Test
    public void TC15() {
        System.out.println("TC15 - User can open 'Book ticket' page by click on 'Book ticket' link in 'Ticket price'");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);
        homePage.gotoTicketPricePage();

        trainPriceListPage.checkPrice("Sài Gòn", "Phan Thiết");

        ticketPricePage.bookTicket("Soft seat");

    }
}
