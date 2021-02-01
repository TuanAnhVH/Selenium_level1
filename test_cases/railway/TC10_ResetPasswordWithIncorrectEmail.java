package railway;

import common.CommonActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.TestBase;

import java.util.Hashtable;

public class TC10_ResetPasswordWithIncorrectEmail extends TestBase {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @Test(dataProvider = "getDataObjects")
    public void TC10(Hashtable<String, String> data) {
        System.out.println("TC10 - User can't reset password if enter incorrect email address");

        System.out.println("Go to 'Login' page.");
        homePage.gotoLoginPage();

        System.out.println("Go to 'Forgot Password' page.");
        loginPage.gotoForgotPasswordPage();

        System.out.println("Reset password with invalid Email.");
        String email = getRandomEmail();
        forgotPasswordPage.resetPassword(email);

        System.out.println("Check the error message.");
        Assert.assertEquals(forgotPasswordPage.getErrorMsg().getText(),data.get("expectedMessage"));
    }
}
