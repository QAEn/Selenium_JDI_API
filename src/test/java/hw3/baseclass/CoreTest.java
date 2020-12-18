package hw3.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public abstract class CoreTest {

    public WebDriver driver;
    public SoftAssert softAssertion;
    public WebDriverWait wait;
    public BaseClass commonSteps;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver =  new DriverManager().setupDriver();
        wait = new WebDriverWait(driver, 5);
        softAssertion = new SoftAssert();
        commonSteps = new BaseClass(driver, softAssertion, wait);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}