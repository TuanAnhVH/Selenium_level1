package railway;

import common.CommonActions;
import constant.Constant;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testbase.TestBase;

public class TC06_AdditionalPagesDisplayAfterLogin extends TestBase {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void TC06() {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("TC06 - Additional pages display once user logged in");

        System.out.println("Go to 'Login' page.");
        homePage.gotoLoginPage();

        System.out.println("Login to Railway.");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Check additional pages is exist.");
        softAssert.assertTrue(doesControlExist(homePage.tabMyTicket), "my ticket tab is not displayed");
        softAssert.assertTrue(doesControlExist(homePage.tabChangePassword), "Change password tab is not displayed");
        softAssert.assertTrue(doesControlExist(homePage.tabLogout), "Logout tab is not displayed");
        softAssert.assertAll();
    }
}
