package Railway;

import Common.CommonActions;
import Constant.Constant;
import org.testng.annotations.Test;
import testbase.TestBase;

public class TC02_LoginWithBlankUsername extends TestBase {
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void TC02() {
        System.out.println("TC02 - User can't login with blank 'Username' textbox");

        System.out.println("Go to 'Login' page.");
        homePage.gotoLoginPage();

        System.out.println("Login with blank username.");
        loginPage.login("", Constant.PASSWORD);

        System.out.println("Check the error message displays.");
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        CommonActions.checkMessageDisplays(loginPage._lblLoginErrorMsg, expectedMsg);
    }
}
