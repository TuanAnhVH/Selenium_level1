package railway;

import common.CommonActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testbase.TestBase;

import java.util.Hashtable;

public class TC11_CreateAcountWithBlankPwdAndPID extends TestBase {
    private final HomePage homePage = new HomePage();
    private final RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getDataObjects")
    public void TC11(Hashtable<String, String> data) {
        System.out.println("TC11 - User can't create account while password and PID fields are empty");
        SoftAssert softAssert = new SoftAssert();

        System.out.println("Go to the 'Register' page.");
        homePage.gotoRegisterPage();

        System.out.println("Register with password and PID are blank");
        String email = getRandomEmail();
        registerPage.register(email, "", "", "");

        System.out.println("Check the register message displays.");
        softAssert.assertEquals(registerPage.getLblErrorMsg().getText(),data.get("expectedRegisterMessage"));

        System.out.println("Check the error password message displays.");
        softAssert.assertEquals(registerPage.getLblPasswordError().getText(),data.get("expectedPasswordMessage"));

        System.out.println("Check the error PID message displays.");
        softAssert.assertEquals(registerPage.getLblPIDError().getText(),data.get("expectedPIDMessage"));

        System.out.println("Report the checking result");
        softAssert.assertAll();
    }
}
