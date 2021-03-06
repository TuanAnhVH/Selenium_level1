package railway;

import common.CommonActions;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.TestBase;

import java.util.Hashtable;

public class TC05_LoginSeveralTimeWithWrongPassword extends TestBase {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "getDataObjects")
    public void TC05(Hashtable<String, String> data) {
        System.out.println("TC05 - System shows message when user enters wrong password several times");

        System.out.println("Go to 'Login' page.");
        homePage.gotoLoginPage();

        System.out.println("Login several times with invalid password.");
        loginPage.loginMutipleTimes(Constant.USERNAME, Constant.PASSWORD + "1", 4);

        System.out.println("Check the error message displays");
        Assert.assertEquals(loginPage.getErrorMsg().getText(),data.get("expectedMessage"));
    }
}
