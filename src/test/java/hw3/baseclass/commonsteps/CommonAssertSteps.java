package hw3.baseclass.commonsteps;

import hw3.baseclass.GetProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import static hw3.baseclass.GetProperties.NameOfProperty.EXERCISE;
import static hw3.baseclass.GetProperties.NameOfProperty.EXERCISE_DATA;

public class CommonAssertSteps {

    private WebDriver driver;
    private SoftAssert softAssertion;
    private GetProperties getExerciseProperties = new GetProperties(EXERCISE);
    private GetProperties getExerciseDataProperties = new GetProperties(EXERCISE_DATA);

    public CommonAssertSteps(WebDriver driver, SoftAssert softAssertion) {
        this.softAssertion = softAssertion;
        this.driver = driver;
    }

    //STEP #2: Assert Browser title
    //DATA: "Home Page"
    //EXPECTED RESULT: Browser title equals "Home Page"
    public void assertBrowserTitle() {
        String expected = getExerciseDataProperties.getResource("titleName");
        softAssertion.assertEquals(driver.getTitle(), expected,
                "Incorrect page title");
    }

    //STEP #4: Assert Username is logged
    //DATA: "ROMAN IOVLEV"
    //EXPECTED RESULT: Name is displayed and equals to expected result
    public void assertUserName() {
        String assertUserName = getExerciseProperties.getResource("assertUserName");
        WebElement userName = driver.findElement(By.cssSelector(assertUserName));
        String actual = userName.getText();
        String expected = getExerciseDataProperties.getResource("username");
        softAssertion.assertEquals(actual, expected,
                "Incorrect username");
    }

    public void assertAll() {
        softAssertion.assertAll();
    }
}