package testbase;

import common.CommonActions;
import common.Utilities;
import constant.Constant;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase extends Utilities {

    @Parameters("browser")
    @BeforeClass()
    public void beforeClass(@Optional("FireFox") String browser) {
        System.out.println("Pre-condition");
        setupBrowser(browser);
        maximizeBrowser();
        CommonActions.navigateToRailway();
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Post-condition");
//        Constant.WEBDRIVER.quit();
    }
}
