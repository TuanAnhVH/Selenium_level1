package Railway;

import Common.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends GeneralPage {
    //Locators
    protected final By _txtEmail = By.id("email");
    protected final By _btnSend = By.xpath("//input[@value='Send Instructions']");
    protected final By _lblErrorMsg = By.xpath("//p[@class='message error']");

    //Elements
    protected WebElement getTxtEmail() {
        return CommonActions.getElement(_txtEmail);
    }

    protected WebElement getbtnSend() {
        return CommonActions.getElement(_btnSend);
    }

    protected WebElement getErrorMsg() {
        return CommonActions.getElement(_lblErrorMsg);
    }

    //Methods
    public void resetPassword(String email) {
        CommonActions.enterDataToTextbox(getTxtEmail(), email);
        getbtnSend().click();
    }

}
