package railway;

import common.CommonActions;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.TestBase;

public class TC08_LoginWithAnUnactivedAccount extends TestBase {
    private final HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    private final RegisterPage registerPage = new RegisterPage();

    @Test
    public void TC08
            () {
        System.out.println("TC08 - User can't login with an account hasn't been activated");

        System.out.println("Go to 'Register' page.");
        homePage.gotoRegisterPage();

        System.out.println("Register with valid data.");
        String email = CommonActions.getRandomEmail();
        registerPage.register(email, Constant.PASSWORD, Constant.PASSWORD, Constant.PID);

        System.out.println("Go to 'Login' page.");
        homePage.gotoLoginPage();

        System.out.println("Login with recent created account.");
        loginPage.login(email, Constant.PASSWORD);

        System.out.println("Check error message is exist");
        Assert.assertTrue(CommonActions.doesControlExist(loginPage._lblLoginErrorMsg),"Error message is not displayed");

        System.out.println("Check error message displays");
        String ExpectedMsg = "Invalid username or password. Please try again.";
        CommonActions.checkMessageDisplays(loginPage._lblLoginErrorMsg,ExpectedMsg);
    }
}
