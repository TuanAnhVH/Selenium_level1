package Railway;

import Common.CommonActions;
import Constant.Constant;
import org.testng.annotations.Test;
import testbase.TestBase;


public class LoginTest extends TestBase {
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");

        homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String expectedMsg = "Welcome " + Constant.USERNAME;
        CommonActions.checkMessageDisplays(homePage.lblWelcomeMessage, expectedMsg);

        loginPage.logout();
    }

    @Test
    public void TC02() {
        System.out.println("TC02 - User can't login with blank 'Username' textbox");

        homePage.gotoLoginPage();

        loginPage.login("", Constant.PASSWORD);

        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        CommonActions.checkMessageDisplays(loginPage._lblLoginErrorMsg, expectedMsg);
    }

    @Test
    public void TC03() {
        System.out.println("TC03 - User cannot log into Railway with invalid password");

        loginPage.login(Constant.USERNAME, Constant.PASSWORD + "1");

        String expectedMsg = "Invalid username or password. Please try again.";
        CommonActions.checkMessageDisplays(loginPage._lblLoginErrorMsg, expectedMsg);
    }

    @Test
    public void TC05() {
        System.out.println("TC05 - System shows message when user enters wrong password several times");

        loginPage.loginMutipleTimes(Constant.USERNAME, Constant.PASSWORD+"1",4);

        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        CommonActions.checkMessageDisplays(loginPage._lblLoginErrorMsg, expectedMsg);
    }

    @Test
    public void TC06() {
        System.out.println("TC06 - Additional pages display once user logged in");

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        CommonActions.checkControlExist(homePage.tabMyTicket, "my ticket tab is not displayed");

        CommonActions.checkControlExist(homePage.tabChangePassword, "Change password tab is not displayed");

        CommonActions.checkControlExist(homePage.tabLogout, "Logout tab is not displayed");
    }

}
