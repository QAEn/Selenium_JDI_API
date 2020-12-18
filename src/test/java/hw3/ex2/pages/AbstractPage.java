package hw3.ex2.pages;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public abstract class AbstractPage {
    public WebDriver driver;
    public SoftAssert softAssertion;

    public abstract void openPage();

    public abstract void checkTitle();

    public AbstractPage(WebDriver driver, SoftAssert softAssertion) {
        this.driver = driver;
        this.softAssertion = softAssertion;
    }
}