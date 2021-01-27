package railway;

import common.CommonActions;
import common.DataProviders;
import constant.Constant;
import org.testng.annotations.Test;
import testbase.TestBase;

import java.util.Hashtable;

public class TC02_LoginWithBlankUsername extends TestBase {
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "getData", dataProviderClass = DataProviders.class)
    public void TC02(Hashtable<String, String> data) {
        System.out.println("TC02 - User can't login with blank 'Username' textbox");

        System.out.println("Go to 'Login' page.");
        homePage.gotoLoginPage();

        System.out.println("Login with blank username.");
        loginPage.login("", Constant.PASSWORD);

        System.out.println("Check the error message displays.");
        CommonActions.checkMessageDisplays(loginPage.lblLoginErrorMsg, data.get("expectedMessage"));
    }
}
