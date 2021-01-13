package hw5.services.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import hw5.services.utility.GetProperties;
import static hw5.services.utility.GetProperties.NameOfProperty.EXERCISE;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected GetProperties getExerciseProperties = new GetProperties(EXERCISE);

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }
}