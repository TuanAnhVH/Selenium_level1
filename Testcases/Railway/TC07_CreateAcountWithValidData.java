package Railway;

import Common.CommonActions;
import Constant.Constant;
import org.testng.annotations.Test;
import testbase.TestBase;

public class TC07_CreateAcountWithValidData extends TestBase {
    private final HomePage homePage = new HomePage();
    private final RegisterPage registerPage = new RegisterPage();

    @Test
    public void TC07() {
        System.out.println("TC07 - User can create new account");

        System.out.println("Go to 'Register' page.");
        homePage.gotoRegisterPage();

        System.out.println("Register with valid data.");
        String email = CommonActions.getRandomEmail();
        registerPage.register(email, Constant.PASSWORD, Constant.PASSWORD, Constant.PID);

        System.out.println("Check the register message displays.");
        String expectedMsg = "Registration Confirmed! You can now log in to the site.";
        CommonActions.checkMessageDisplays(registerPage._lblRegisterSuccessMsg, expectedMsg);
    }
}
