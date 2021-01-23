package Railway;

import Common.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage extends GeneralPage {
    public final By _emailLink = By.xpath("//div[@class='contact']//b[contains(text(),'Email')]//following-sibling::a");

    protected WebElement getEmailLink() {
        return CommonActions.getElement(_emailLink);
    }
}
