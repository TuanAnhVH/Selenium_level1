package Railway;

import Common.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {

    //Locators
    protected final By _txtUsername = By.id("username");
    protected final By _txtPassword = By.id("password");
    protected final By _btnLogin = By.xpath("//input[@value='Login']");
    protected final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    protected final By _linkForgotPassword = By.xpath("//a[@href='/Account/ForgotPassword.cshtml']");

    //Elements
    protected WebElement getTxtUsername() {
        return CommonActions.getElement(_txtUsername);
    }

    protected WebElement getTxtPassword() {
        return CommonActions.getElement(_txtPassword);
    }

    protected WebElement getBtnLogin() {
        return CommonActions.getElement(_btnLogin);
    }

    protected WebElement getErrorMsg() {
        return CommonActions.getElement(_lblLoginErrorMsg);
    }

    protected WebElement getLinkForgotPassword() {
        return CommonActions.getElement(_linkForgotPassword);
    }

    //Element methods
    public void gotoForgotPasswordPage() {
        getLinkForgotPassword().click();
    }

    //Methods
    public void login(String username, String password) {
        CommonActions.enterDataToTextbox(getTxtUsername(), username);
        CommonActions.enterDataToTextbox(getTxtPassword(), password);
        getBtnLogin().click();
    }
    public void loginMutipleTimes(String username, String password,int times) {
        while (times>0)
        {
            login(username,password);
            times--;
        }
    }
}
