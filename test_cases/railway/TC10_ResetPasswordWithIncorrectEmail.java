package railway;

import common.CommonActions;
import org.testng.annotations.Test;
import testbase.TestBase;

public class TC10_ResetPasswordWithIncorrectEmail extends TestBase {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @Test
    public void TC10() {
        System.out.println("TC10 - User can't reset password if enter incorrect email address");
        CommonActions.navigateToRailway();

        System.out.println("Go to 'Login' page.");
        homePage.gotoLoginPage();

        System.out.println("Go to 'Forgot Password' page.");
        loginPage.gotoForgotPasswordPage();

        System.out.println("Reset password with invalid Email.");
        String email = CommonActions.getRandomEmail();
        forgotPasswordPage.resetPassword(email);

        System.out.println("Check the error message.");
        String expectedMsg = "This email address doesn't exist.";
        CommonActions.checkMessageDisplays(forgotPasswordPage._lblErrorMsg,expectedMsg);
    }
}
