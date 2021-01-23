package Railway;

import Common.CommonActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.TestBase;

public class ContactTest extends TestBase {
    private HomePage homePage = new HomePage();
    private ContactPage contactPage = new ContactPage();

    @Test
    public void TC04() {
        System.out.println("TC04 - Contact Email contains correct href value which can help to quickly open Outlook Compose Message dialog");

        homePage.gotoContactPage();

        String expectedHref = "mailto:thanh.viet.le@logigear.com";
        String actualHref = contactPage.getEmailLink().getAttribute("href");
        Assert.assertEquals(actualHref,expectedHref,"Email address's href is incorrect");
    }
}
