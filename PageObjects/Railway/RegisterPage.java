package Railway;

import Common.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    //Locators
    protected final By _txtEmail = By.id("email");
    protected final By _txtPassword = By.id("password");
    protected final By _txtConfirmPassword = By.id("confirmPassword");
    protected final By _txtPID = By.id("pid");
    protected final By _btnRegister = By.xpath("//input[@value='Register']");
    protected final By _lblRegisterSuccessMsg = By.xpath("//*[@id='content']/p");
    protected final By _lblRegisterErrorMsg = By.xpath("//p[@class='message error']");
    protected final By _lblPasswordError = By.xpath("//label[@for='password' and @class='validation-error']");
    protected final By _lblPIDError = By.xpath("//label[@for='pid' and @class='validation-error']");

    //Elements
    protected WebElement getTxtEmail() {
        return CommonActions.getElement(_txtEmail);
    }

    protected WebElement getTxtPassword() {
        return CommonActions.getElement(_txtPassword);
    }

    protected WebElement getTxtConfirmPassword() {
        return CommonActions.getElement(_txtConfirmPassword);
    }

    protected WebElement getTxtPID() {
        return CommonActions.getElement(_txtPID);
    }

    protected WebElement getBtnRegister() {
        return CommonActions.getElement(_btnRegister);
    }

    //Methods
    public void register(String email, String password, String confirmPassword, String pidNumber) {
        CommonActions.enterDataToTextbox(getTxtEmail(), email);
        CommonActions.enterDataToTextbox(getTxtPassword(), password);
        CommonActions.enterDataToTextbox(getTxtConfirmPassword(), confirmPassword);
        CommonActions.enterDataToTextbox(getTxtPID(), pidNumber);
        getBtnRegister().submit();
    }

}
