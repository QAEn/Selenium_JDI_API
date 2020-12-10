package hw2.ex2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public abstract class AbstractPage {

    public WebDriver driver;

    public abstract void openPage();
    public abstract void checkTitle();

    public WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public String getPageProperty(String nameOfProperty) {

        final Properties property = new Properties();
        try (final FileInputStream fis = new FileInputStream("src/test/resources/hw2/properties/exercise_2.properties"))
        {
            property.load(fis);
        } catch (FileNotFoundException e) {
            System.out.println("File with resources of page was not founded (exercise 2)");
        } catch (IOException e) {
            System.out.println("IOException for page (exercise 2)");
        }
        return property.getProperty(nameOfProperty);
    }
}
