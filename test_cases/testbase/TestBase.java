package testbase;

import common.CommonActions;
import common.Utilities;
import constant.Constant;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class TestBase extends CommonActions {

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
        Constant.WEBDRIVER.quit();
    }

    @DataProvider(name = "getDataObjects")
    public Object[] getDataObjects() {
        String className = getClass().getSimpleName();
        return getData(className,Constant.DATA_FILE_PATH);
    }
}
