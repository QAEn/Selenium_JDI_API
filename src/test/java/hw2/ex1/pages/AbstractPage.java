package hw2.ex1.pages;

import hw2.baseclass.GetProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static hw2.baseclass.GetProperties.NumberOfExercise.FIRST_EXERCISE;

public abstract class AbstractPage {

    public WebDriver driver;
    public GetProperties getProperties = new GetProperties(FIRST_EXERCISE);

    public abstract void openPage();

    public abstract void checkTitle();

    public WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(by));
    }
}