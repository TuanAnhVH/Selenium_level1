package Railway;

import Common.CommonActions;
import Common.Utilities;
import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.TestBase;

import java.util.Random;

public class ForgotPasswordTest extends TestBase {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @Test
    public void TC10() {
        System.out.println("TC10 - User can't reset password if enter incorrect email address");
        CommonActions.navigateToRailway();

        homePage.gotoLoginPage();

        loginPage.gotoForgotPasswordPage();

        String email = CommonActions.getRandomEmail();
        forgotPasswordPage.resetPassword(email);

        String expectedMsg = "This email address doesn't exist.";
        CommonActions.checkMessageDisplays(forgotPasswordPage._lblErrorMsg,expectedMsg);
    }
}
