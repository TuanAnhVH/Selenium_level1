package railway;

import common.CommonActions;
import common.DataProviders;
import constant.Constant;
import org.testng.annotations.Test;
import testbase.TestBase;

import java.util.Hashtable;

public class TC07_CreateAcountWithValidData extends TestBase {
    private final HomePage homePage = new HomePage();
    private final RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData", dataProviderClass = DataProviders.class)
    public void TC07(Hashtable<String, String> data) {
        System.out.println("TC07 - User can create new account");

        System.out.println("Go to 'Register' page.");
        homePage.gotoRegisterPage();

        System.out.println("Register with valid data.");
        String email = CommonActions.getRandomEmail();
        registerPage.register(email, Constant.PASSWORD, Constant.PASSWORD, Constant.PID);

        System.out.println("Check the register message displays.");
        CommonActions.checkMessageDisplays(registerPage.lblRegisterSuccessMsg, data.get("expectedMessage"));
    }
}
