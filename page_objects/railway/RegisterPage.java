package railway;

import common.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    //Locators
    protected final By txtEmail = By.id("email");
    protected final By txtPassword = By.id("password");
    protected final By txtConfirmPassword = By.id("confirmPassword");
    protected final By txtPID = By.id("pid");
    protected final By btnRegister = By.xpath("//input[@value='Register']");
    protected final By lblRegisterSuccessMsg = By.xpath("//*[@id='content']/p");
    protected final By lblRegisterErrorMsg = By.xpath("//p[@class='message error']");
    protected final By lblPasswordError = By.xpath("//label[@for='password' and @class='validation-error']");
    protected final By lblPIDError = By.xpath("//label[@for='pid' and @class='validation-error']");

    //Elements
    protected WebElement getTxtEmail() {
        return CommonActions.getElement(txtEmail);
    }

    protected WebElement getTxtPassword() {
        return CommonActions.getElement(txtPassword);
    }

    protected WebElement getTxtConfirmPassword() {
        return CommonActions.getElement(txtConfirmPassword);
    }

    protected WebElement getTxtPID() {
        return CommonActions.getElement(txtPID);
    }

    protected WebElement getBtnRegister() {
        return CommonActions.getElement(btnRegister);
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
