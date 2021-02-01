package railway;

import common.CommonActions;
import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class RegisterPage extends GeneralPage{
    //Locators
    protected final By txtEmail = By.id("email");
    protected final By txtPassword = By.id("password");
    protected final By txtConfirmPassword = By.id("confirmPassword");
    protected final By txtPID = By.id("pid");
    protected final By btnRegister = By.xpath("//input[@value='Register']");
    protected final By lblRegisterSuccessMsg = By.xpath("//div[@id='content']/p");
    protected final By lblRegisterErrorMsg = By.xpath("//p[@class='message error']");
    protected final By lblPasswordError = By.xpath("//label[@for='password' and @class='validation-error']");
    protected final By lblPIDError = By.xpath("//label[@for='pid' and @class='validation-error']");

    //Elements
    protected WebElement getTxtEmail() {
        return this.getElement(txtEmail);
    }

    protected WebElement getTxtPassword() {
        return this.getElement(txtPassword);
    }

    protected WebElement getTxtConfirmPassword() { return this.getElement(txtConfirmPassword); }

    protected WebElement getTxtPID() {
        return this.getElement(txtPID);
    }

    protected WebElement getBtnRegister() { return this.getElement(btnRegister); }

    protected WebElement getLblSuccessMsg() { return this.getElement(lblRegisterSuccessMsg);}

    protected WebElement getLblErrorMsg() { return this.getElement(lblRegisterErrorMsg); }

    protected WebElement getLblPasswordError() { return this.getElement(lblPasswordError); }

    protected WebElement getLblPIDError() { return this.getElement(lblPIDError); }

    //Methods
    public void register(String email, String password, String confirmPassword, String pidNumber) {
        enterDataToTextbox(getTxtEmail(), email);
        enterDataToTextbox(getTxtPassword(), password);
        enterDataToTextbox(getTxtConfirmPassword(), confirmPassword);
        enterDataToTextbox(getTxtPID(), pidNumber);
        clickOnElement(getBtnRegister());
    }
}
