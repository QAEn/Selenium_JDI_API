package hw8;

import org.testng.annotations.*;

import hw8.core.methods.*;
import hw8.steps.assertionlayer.CheckerOfAnswers;

public abstract class CoreTest {

    protected CheckText checkTextApi;
    protected CheckTexts checkTextsApi;
    protected CheckerOfAnswers checkerOfAnswers;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        checkTextApi = new CheckText();
        checkTextsApi = new CheckTexts();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        checkTextApi = null;
        checkTextsApi = null;
    }
}