package hw3.ex1.pages;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public abstract class AbstractPage {
    public WebDriver driver;
    public SoftAssert softAssertion;

    public AbstractPage(WebDriver driver, SoftAssert softAssertion) {
        this.driver = driver;
        this.softAssertion = softAssertion;
    }
}