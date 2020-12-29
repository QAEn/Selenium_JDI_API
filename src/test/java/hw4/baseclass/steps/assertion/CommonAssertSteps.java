package hw4.baseclass.steps.assertion;

import hw4.baseclass.utility.GetProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import static hw4.baseclass.utility.GetProperties.NameOfProperty.EXERCISE;

public class CommonAssertSteps {

    private WebDriver driver;
    private SoftAssert softAssertion;
    private GetProperties getExerciseProperties = new GetProperties(EXERCISE);


    public CommonAssertSteps(WebDriver driver, SoftAssert softAssertion) {
        this.softAssertion = softAssertion;
        this.driver = driver;
    }

    @Step("STEP #2: Assert Browser title")
    public void assertBrowserTitle(String actual, String expected) {
        softAssertion.assertEquals(actual, expected,
                "Incorrect page title");
    }

    @Step("STEP #4: Assert Username is logged")
    public void assertUserName(String actual, String expected) {
        String assertUserName = getExerciseProperties.getResource("assertUserName");
        WebElement userName = driver.findElement(By.cssSelector(assertUserName));
        softAssertion.assertEquals(actual, expected,
                "Incorrect username");
    }

    public void checkAll() {
        softAssertion.assertAll();
    }
}