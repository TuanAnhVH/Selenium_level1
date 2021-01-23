package Railway;

import Common.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //locators

    protected final By tabContact = By.xpath("//div[@id='menu']//a[@href='/Page/Contact.cshtml']");
    protected final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    protected final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    protected final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    protected final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    protected final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    protected final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    protected final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");

    //Elements
    protected WebElement getTabContact() {
        return CommonActions.getElement(tabContact);
    }

    protected WebElement getTabBookTicket() {
        return CommonActions.getElement(tabBookTicket);
    }

    protected WebElement getTabLogout() {
        return CommonActions.getElement(tabLogout);
    }

    protected WebElement getTabMyTicket() {
        return CommonActions.getElement(tabMyTicket);
    }

    protected WebElement getRegister() {
        return CommonActions.getElement(tabRegister);
    }

    protected WebElement getTabChangePassword() {
        return CommonActions.getElement(tabChangePassword);
    }

    protected WebElement getTabLogin() {
        return CommonActions.getElement(tabLogin);
    }

    protected WebElement getLblWelcomeMessage() {
        return CommonActions.getElement(lblWelcomeMessage);
    }

    //Methods

    public void gotoContactPage() {
        this.getTabContact().click();
    }

    public void gotoBookTicketPage() {
        this.getTabBookTicket().click();
    }

    public void gotoMyTicketPage() {
        this.getTabMyTicket().click();
    }

    public void gotoRegisterPage() {
        this.getRegister().click();
    }

    public void gotoChangePasswordPage() {
        this.getTabChangePassword().click();
    }

    public void gotoLoginPage() {
        this.getTabLogin().click();
    }

    public void logout() {
        this.getTabLogout().click();
    }

}
