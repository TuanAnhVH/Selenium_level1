package railway;

import common.CommonActions;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage extends CommonActions {
    //locators

    protected final By tabContact = By.xpath("//div[@id='menu']//a[@href='/Page/Contact.cshtml']");
    protected final By tabTicketPrice = By.xpath("//div[@id='menu']//a[@href='/Page/TrainPriceListPage.cshtml']");
    protected final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    protected final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    protected final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    protected final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    protected final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    protected final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    protected final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");

    //Elements
    protected WebElement getTabContact() {
        return this.getElement(tabContact);
    }

    protected WebElement getTabTicketPrice() {
        return this.getElement(tabTicketPrice);
    }

    protected WebElement getTabBookTicket() {
        return this.getElement(tabBookTicket);
    }

    protected WebElement getTabLogout() {
        return this.getElement(tabLogout);
    }

    protected WebElement getTabMyTicket() {
        return this.getElement(tabMyTicket);
    }

    protected WebElement getRegister() {
        return CommonActions.getElement(tabRegister);
    }

    protected WebElement getTabChangePassword() {
        return this.getElement(tabChangePassword);
    }

    protected WebElement getTabLogin() {
        return this.getElement(tabLogin);
    }

    protected WebElement getLblWelcomeMessage() { return this.getElement(lblWelcomeMessage); }

    //Methods

    public void gotoContactPage() {
        this.getTabContact().click();
    }

    public void gotoTicketPricePage() { this.getTabTicketPrice().click(); }

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
