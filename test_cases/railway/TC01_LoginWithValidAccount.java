package railway;

import common.CommonActions;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.TestBase;

import java.util.Hashtable;

public class TC01_LoginWithValidAccount extends TestBase {
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @Test()
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");

        System.out.println("Go to 'Login' page.");
        homePage.gotoLoginPage();

        System.out.println("Login with a valid account.");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Check the welcome message displays.");
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(homePage.getLblWelcomeMessage().getText(),expectedMsg);
    }
}
