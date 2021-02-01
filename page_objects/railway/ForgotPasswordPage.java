package railway;

import common.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends GeneralPage {
    //Locators
    protected final By txtEmail = By.id("email");
    protected final By btnSend = By.xpath("//input[@value='Send Instructions']");
    protected final By lblErrorMsg = By.xpath("//p[@class='message error']");

    //Elements
    protected WebElement getTxtEmail() {
        return this.getElement(txtEmail);
    }

    protected WebElement getbtnSend() {
        return this.getElement(btnSend);
    }

    protected WebElement getErrorMsg() {
        return this.getElement(lblErrorMsg);
    }

    //Methods
    public void resetPassword(String email) {
        this.enterDataToTextbox(getTxtEmail(), email);
        getbtnSend().click();
    }

}
