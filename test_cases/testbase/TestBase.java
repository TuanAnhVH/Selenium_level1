package testbase;

import common.CommonActions;
import common.Utilities;
import constant.Constant;
import org.testng.annotations.*;

public class TestBase extends Utilities {

    @Parameters("browser")
    @BeforeClass()
    public void beforeClass(@Optional ("fireFox") String  browser)
    {
        System.out.println("Pre-condition");
        setupBrowser(browser);
        maximizeBrowser();
        CommonActions.navigateToRailway();
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
}
