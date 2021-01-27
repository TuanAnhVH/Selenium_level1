package railway;

import common.CommonActions;
import common.DataProviders;
import org.testng.annotations.Test;
import testbase.TestBase;

import java.util.Hashtable;

public class TC11_CreateAcountWithBlankPwdAndPID extends TestBase {
    private final HomePage homePage = new HomePage();
    private final RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData", dataProviderClass = DataProviders.class)
    public void TC11(Hashtable<String, String> data) {
        System.out.println("TC11 - User can't create account while password and PID fields are empty");
        CommonActions.navigateToRailway();

        System.out.println("Go to the'Register' page.");
        homePage.gotoRegisterPage();

        System.out.println("Register with password and PID are blank");
        String email = CommonActions.getRandomEmail();
        registerPage.register(email, "", "", "");

        System.out.println("Check the register message displays.");
        CommonActions.checkMessageDisplays(registerPage.lblRegisterErrorMsg, data.get("expectedRegisterMessage"));

        System.out.println("Check the error password message displays.");
        CommonActions.checkMessageDisplays(registerPage.lblPasswordError, data.get("expectedPasswordMessage"));

        System.out.println("Check the error PID message displays.");
        CommonActions.checkMessageDisplays(registerPage.lblPIDError, data.get("expectedPIDMessage"));
    }
}
