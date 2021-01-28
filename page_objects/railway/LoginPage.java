package railway;

import common.CommonActions;
import common.Utilities;
import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {

    //Locators
    protected final By txtUsername = By.id("username");
    protected final By txtPassword = By.id("password");
    protected final By btnLogin = By.xpath("//input[@value='Login']");
    protected final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    protected final By linkForgotPassword = By.xpath("//a[@href='/Account/ForgotPassword.cshtml']");

    //Elements
    protected WebElement getTxtUsername() {
        return CommonActions.getElement(txtUsername);
    }

    protected WebElement getTxtPassword() {
        return CommonActions.getElement(txtPassword);
    }

    protected WebElement getBtnLogin() {
        return CommonActions.getElement(btnLogin);
    }

    protected WebElement getErrorMsg() {
        return CommonActions.getElement(lblLoginErrorMsg);
    }

    protected WebElement getLinkForgotPassword() {
        return CommonActions.getElement(linkForgotPassword);
    }

    //Element methods
    public void gotoForgotPasswordPage() {
        getLinkForgotPassword().click();
    }

    //Methods
    public void login(String username, String password) {
        CommonActions.enterDataToTextbox(getTxtUsername(), username);
        CommonActions.enterDataToTextbox(getTxtPassword(), password);
        CommonActions.clickOnElement(getBtnLogin());
        Utilities.waitForLoad();
    }
    public void loginMutipleTimes(String username, String password,int times) {
        while (times>0)
        {
            login(username,password);
            times--;
        }
    }
}
