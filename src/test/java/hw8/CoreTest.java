package hw8;

import hw8.core.methods.CheckText;
import hw8.core.methods.CheckTexts;
import org.testng.ITestContext;
import org.testng.annotations.*;

public abstract class CoreTest {

    protected CheckText checkTextApi;
    protected CheckTexts checkTextsApi;

    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestContext testContext) {
        checkTextApi = new CheckText();
        checkTextsApi = new CheckTexts();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        checkTextApi = null;
        checkTextsApi = null;
    }

}