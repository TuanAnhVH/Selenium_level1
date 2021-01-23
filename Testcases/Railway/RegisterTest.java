package Railway;

import Common.CommonActions;
import Constant.Constant;
import org.testng.annotations.Test;
import testbase.TestBase;

import java.util.Random;

public class RegisterTest extends TestBase {
    private final HomePage homePage = new HomePage();
    private final RegisterPage registerPage = new RegisterPage();

    @Test
    public void TC07() {
        System.out.println("TC07 - User can create new account");

        homePage.gotoRegisterPage();
        String email = CommonActions.curentTime()+"e@gmail.com";
        registerPage.register(email, Constant.PASSWORD, Constant.PASSWORD, Constant.PID);

        String expectedMsg = "Registration Confirmed! You can now log in to the site.";
        CommonActions.checkMessageDisplays(registerPage._lblRegisterSuccessMsg, expectedMsg);
    }

    @Test
    public void TC011() {
        System.out.println("TC11 - User can't create account while password and PID fields are empty");
        CommonActions.navigateToRailway();

        homePage.gotoRegisterPage();
        String email = CommonActions.curentTime()+"e@gmail.com";

        registerPage.register(email, "", "", "");

        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        CommonActions.checkMessageDisplays(registerPage._lblRegisterErrorMsg, expectedMsg);

        expectedMsg = "Invalid password length";
        CommonActions.checkMessageDisplays(registerPage._lblPasswordError, expectedMsg);

        expectedMsg = "Invalid ID length";
        CommonActions.checkMessageDisplays(registerPage._lblPIDError, expectedMsg);
    }
}
