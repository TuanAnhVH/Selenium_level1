package testbase;

import Common.CommonActions;
import Common.Utilities;
import Constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase extends Utilities {
    @BeforeClass
    public void beforeClass()
    {
        System.out.println("Pre-condition");
        setupBrowser("Chrome");
        maximizeBrowser();
        CommonActions.navigateToRailway();
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Post-condition");
//        Constant.WEBDRIVER.quit();
    }
}
