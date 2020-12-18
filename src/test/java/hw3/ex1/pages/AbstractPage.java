package hw3.ex1.pages;

import hw3.baseclass.GetProperties;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import static hw3.baseclass.GetProperties.NumberOfExercise.FIRST_EXERCISE;

public abstract class AbstractPage {
    public WebDriver driver;
    public SoftAssert softAssertion;
    public GetProperties getProperties = new GetProperties(FIRST_EXERCISE);
}