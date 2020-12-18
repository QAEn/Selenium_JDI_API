package hw2.baseclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class BaseClass {

    private WebDriver driver;
    private SoftAssert softAssertion;
    private WebDriverWait wait;

    public BaseClass(WebDriver driver, SoftAssert softAssertion, WebDriverWait wait) {
        this.driver = driver;
        this.softAssertion = softAssertion;
        this.wait = wait;
    }

    public void baseMethod() {
        //STEP #1: Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.tagName("html"))));

        //STEP #2: Assert Browser title
        softAssertion.assertEquals(driver.getTitle(), "Home Page",
                "Incorrect page title");

        //STEP #3: Perform login
        WebElement loginCaret = driver.findElement(By.id("user-icon"));
        loginCaret.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#name")))
                .sendKeys("Roman");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")))
                .sendKeys("Jdi1234");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Enter']")))
                .click();

        //STEP #4: Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector("#user-name"));
        softAssertion.assertEquals(userName.getText(), "ROMAN IOVLEV",
                "Incorrect username");
    }
}