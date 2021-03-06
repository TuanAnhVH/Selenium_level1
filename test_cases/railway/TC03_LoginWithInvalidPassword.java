package railway;

import common.CommonActions;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.TestBase;

import java.util.Hashtable;

public class TC03_LoginWithInvalidPassword extends TestBase {
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "getDataObjects")
    public void TC03(Hashtable<String, String> data) {
        System.out.println("TC03 - User cannot log into Railway with invalid password");

        System.out.println("Go to 'Login' page");
        homePage.gotoLoginPage();

        System.out.println("Login with invalid password.");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD + "1");

        System.out.println("Check the error message displays");
        Assert.assertEquals(loginPage.getErrorMsg().getText(),data.get("expectedMessage"));
    }
}
