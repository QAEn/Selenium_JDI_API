package hw4.baseclass;

import hw4.baseclass.webdriver.DriverManager;
import hw4.baseclass.utility.AllureListener;
import hw4.baseclass.steps.assertion.CommonAssertSteps;
import hw4.baseclass.steps.action.FirstExerciseActionStep;
import hw4.baseclass.steps.assertion.FirstExerciseAssertionStep;
import hw4.baseclass.steps.action.SecondExerciseActionStep;
import hw4.baseclass.steps.assertion.SecondExerciseAssertionStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

@Listeners({AllureListener.class})
public abstract class CoreTest {

    protected WebDriver driver;
    protected SoftAssert softAssertion;
    protected WebDriverWait wait;

    protected FirstExerciseActionStep firstExerciseActionStep;
    protected FirstExerciseAssertionStep firstExerciseAssertionStep;

    protected SecondExerciseAssertionStep secondExerciseAssertionStep;
    protected SecondExerciseActionStep secondExerciseActionStep;

    protected CommonAssertSteps commonAssertSteps;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(ITestContext testContext) {
        driver =  DriverManager.setupDriver();
        wait = new WebDriverWait(driver, 5);
        softAssertion = new SoftAssert();

        commonAssertSteps = new CommonAssertSteps(softAssertion);

        firstExerciseActionStep = new FirstExerciseActionStep(driver, wait);
        firstExerciseAssertionStep = new FirstExerciseAssertionStep(driver, softAssertion, wait);

        secondExerciseActionStep = new SecondExerciseActionStep(driver);
        secondExerciseAssertionStep = new SecondExerciseAssertionStep(softAssertion);

        testContext.setAttribute("driver", driver);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}