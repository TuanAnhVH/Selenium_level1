package railway;

import common.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.TestBase;

import java.util.Hashtable;

public class TC04_ContactEmailContainsCorrectHref extends TestBase {
    private HomePage homePage = new HomePage();
    private ContactPage contactPage = new ContactPage();

    @Test(dataProvider = "getData", dataProviderClass = DataProviders.class)
    public void TC04(Hashtable<String, String> data) {
        System.out.println("TC04 - Contact Email contains correct href value which can help to quickly open Outlook Compose Message dialog");

        System.out.println("Go to 'Contact' page.");
        homePage.gotoContactPage();

        System.out.println("Check the email address.");
        String expectedHref = data.get("expectedHref");
        String actualHref = contactPage.getEmailLink().getAttribute("href");
        Assert.assertEquals(actualHref, expectedHref, "Email address's href is incorrect");
    }
}
