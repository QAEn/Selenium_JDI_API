package hw5.services.page;

import hw5.services.utility.GetProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static hw5.services.utility.GetProperties.NameOfProperty.EXERCISE;
import static hw5.services.utility.GetProperties.NameOfProperty.EXERCISE_DATA;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected GetProperties getExerciseProperties = new GetProperties(EXERCISE);
    protected GetProperties getExerciseDataProperties = new GetProperties(EXERCISE_DATA);

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }
}