package Railway;

import Common.CommonActions;
import Constant.Constant;
import com.google.common.base.Verify;
import org.testng.Assert;
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
        softAssert.assertTrue(CommonActions.doesControlExist(homePage.tabMyTicket),"my ticket tab is not displayed");
        softAssert.assertTrue(CommonActions.doesControlExist(homePage.tabChangePassword),"Change password tab is not displayed");
        softAssert.assertTrue(CommonActions.doesControlExist(homePage.tabLogout),"Logout tab is not displayed");
        softAssert.assertAll();
    }
}
