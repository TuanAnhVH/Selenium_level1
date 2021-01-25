package Railway;

import Common.CommonActions;
import org.testng.annotations.Test;
import testbase.TestBase;

public class TC11_CreateAcountWithBlankPwdAndPID extends TestBase {
    private final HomePage homePage = new HomePage();
    private final RegisterPage registerPage = new RegisterPage();
    @Test
    public void TC011() {
        System.out.println("TC11 - User can't create account while password and PID fields are empty");
        CommonActions.navigateToRailway();

        System.out.println("Go to the'Register' page.");
        homePage.gotoRegisterPage();

        System.out.println("Register with password and PID are blank");
        String email = CommonActions.getRandomEmail();
        registerPage.register(email, "", "", "");

        System.out.println("Check the register message displays.");
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        CommonActions.checkMessageDisplays(registerPage._lblRegisterErrorMsg, expectedMsg);

        System.out.println("Check the error password message displays.");
        expectedMsg = "Invalid password length";
        CommonActions.checkMessageDisplays(registerPage._lblPasswordError, expectedMsg);

        System.out.println("Check the error PID message displays.");
        expectedMsg = "Invalid ID length";
        CommonActions.checkMessageDisplays(registerPage._lblPIDError, expectedMsg);
    }
}
