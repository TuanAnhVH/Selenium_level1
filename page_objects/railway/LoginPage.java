package railway;

import common.CommonActions;
import common.Utilities;
import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage extends GeneralPage {

    //Locators
    protected final By txtUsername = By.id("username");
    protected final By txtPassword = By.id("password");
    protected final By btnLogin = By.xpath("//input[@value='Login']");
    protected final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    protected final By linkForgotPassword = By.xpath("//a[@href='/Account/ForgotPassword.cshtml']");

    //Elements
    protected WebElement getTxtUsername() {
        return this.getElement(txtUsername);
    }

    protected WebElement getTxtPassword() {
        return this.getElement(txtPassword);
    }

    protected WebElement getBtnLogin() {
        return this.getElement(btnLogin);
    }

    protected WebElement getErrorMsg() {
        return this.getElement(lblLoginErrorMsg);
    }

    protected WebElement getLinkForgotPassword() {
        return this.getElement(linkForgotPassword);
    }

    //Element methods
    public void gotoForgotPasswordPage() {
        getLinkForgotPassword().click();
    }

    //Methods
    public void login(String username, String password) {
        enterDataToTextbox(getTxtUsername(), username);
        enterDataToTextbox(getTxtPassword(), password);
        clickOnElement(getBtnLogin());
    }

    public void loginMutipleTimes(String username, String password,int times) {
        while (times>0)
        {
            login(username,password);
            times--;
        }
    }
}
