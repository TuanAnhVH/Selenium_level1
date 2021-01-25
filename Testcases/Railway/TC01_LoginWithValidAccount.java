package Railway;

import Common.CommonActions;
import Constant.Constant;
import org.testng.annotations.Test;
import testbase.TestBase;

public class TC01_LoginWithValidAccount extends TestBase {
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");

        System.out.println("Go to 'Login' page.");
        homePage.gotoLoginPage();

        System.out.println("Login with a valid account.");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Check the welcome message displays.");
        String expectedMsg = "Welcome " + Constant.USERNAME;
        CommonActions.checkMessageDisplays(homePage.lblWelcomeMessage, expectedMsg);

    }
}
