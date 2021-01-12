package hw4.baseclass;

import hw4.baseclass.pages.*;
import hw4.baseclass.steps.action.*;
import hw4.baseclass.steps.assertion.*;
import hw4.baseclass.webdriver.DriverManager;
import hw4.baseclass.utility.AllureListener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

@Listeners({AllureListener.class})
public abstract class CoreTest {

    protected WebDriver driver;
    protected SoftAssert softAssertion;
    protected WebDriverWait wait;

    protected HomePage homePage;
    protected FramePage framePage;
    protected DifferentElementsPage differentElementsPage;

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

        homePage = new HomePage(driver, wait);
        framePage = new FramePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);

        commonAssertSteps = new CommonAssertSteps(softAssertion);

        firstExerciseActionStep = new FirstExerciseActionStep(driver, wait);
        firstExerciseAssertionStep = new FirstExerciseAssertionStep(driver, softAssertion,
                                                                    homePage, framePage);

        secondExerciseActionStep = new SecondExerciseActionStep(driver, differentElementsPage);
        secondExerciseAssertionStep = new SecondExerciseAssertionStep(softAssertion);

        testContext.setAttribute("driver", driver);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}