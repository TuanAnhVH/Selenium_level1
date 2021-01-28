package testbase;

import common.CommonActions;
import common.Utilities;
import constant.Constant;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;

public class TestBase extends Utilities {

    @Parameters("browser")
    @BeforeClass()
    public void beforeClass(@Optional("Chrome") String browser) {
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

    @DataProvider(name = "getDataObject")
    public Object[] getDataObject() {
        String className = getClass().getSimpleName();
        return getData(className,Constant.DATA_FILE_PATH);
    }
}
