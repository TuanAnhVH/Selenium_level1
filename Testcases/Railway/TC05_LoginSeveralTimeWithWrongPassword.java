package Railway;

import Common.CommonActions;
import Constant.Constant;
import org.testng.annotations.Test;
import testbase.TestBase;

public class TC05_LoginSeveralTimeWithWrongPassword extends TestBase {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void TC05() {
        System.out.println("TC05 - System shows message when user enters wrong password several times");

        System.out.println("Go to 'Login' page.");
        homePage.gotoLoginPage();

        System.out.println("Login several times with invalid password.");
        loginPage.loginMutipleTimes(Constant.USERNAME, Constant.PASSWORD+"1",4);

        System.out.println("Check the error message displays");
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        CommonActions.checkMessageDisplays(loginPage._lblLoginErrorMsg, expectedMsg);
    }
}
