package hw2.ex2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class HomePage extends AbstractPage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * STEP #1: Open test site by URL
     * DATA: https://jdi-testing.github.io/jdi-light/index.html
     * EXPECTED RESULT: Test site is opened
     */
    @Override
    public void openPage() {
        driver.get(getPageProperty("homePageURL"));
    }

    /**
     * STEP #2: Assert Browser title
     * DATA: "Home Page"
     * EXPECTED RESULT: Browser title equals "Home Page"
     */
    @Override
    public boolean checkTitle() {
        return driver.getTitle().equals("Home Page") ? true : false;
    }

    /**
     * STEP #3: Perform login
     * DATA: username: Roman, pass: Jdi1234
     * EXPECTED RESULT: User is logged
     */
    public void login() {
        String loginCaret = getPageProperty("loginCaret");
        waitForElementLocatedBy(driver, By.xpath(loginCaret));
        driver.findElement(By.xpath(loginCaret)).click();

        String username = getPageProperty("username");
        waitForElementLocatedBy(driver, By.cssSelector(username));
        driver.findElement(By.cssSelector(username)).sendKeys("Roman");

        String pass = getPageProperty("pass");
        waitForElementLocatedBy(driver, By.cssSelector(pass));
        driver.findElement(By.cssSelector(pass)).sendKeys("Jdi1234");

        String enterBtn = getPageProperty("enterBtn");
        waitForElementLocatedBy(driver, By.xpath(enterBtn));
        driver.findElement(By.xpath(enterBtn)).click();
    }

    /**
     * STEP #4: Assert User name in the left-top side of screen that user is loggined
     * DATA: "ROMAN IOVLEV"
     * EXPECTED RESULT: Name is displayed and equals to expected result
     */
    public void assertUserName() {
        String userName = getPageProperty("userName");
        waitForElementLocatedBy(driver, By.cssSelector(userName));
        String actual = driver.findElement(By.cssSelector(userName)).getText();
        String expected = "ROMAN IOVLEV";
        Assert.assertEquals(actual, expected);
    }

    /**
     * STEP #5: Open through the header menu Service -> Different Elements Page
     * DATA:
     * EXPECTED RESULT: Page is opened
     */
    public void openDifferentElementsPage() {

    }

    /**
     * STEP #6: Select checkboxes
     * DATA: Water, Wind
     * EXPECTED RESULT: Elements are checked
     */
    public void selectCheckboxes() {
    }

    /**
     * STEP #7: Select radio
     * DATA: Selen
     * EXPECTED RESULT: Element is checked
     */
    public void selectRadio() {
    }

    /**
     * STEP #8: Select in dropdown
     * DATA: Yellow
     * EXPECTED RESULT: Element is selected
     */
    public void selectInDropdown() {
    }

    /**
     * STEP #9:
     * Assert that:
     *•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
     *•	for radio button there is a log row and value is corresponded to the status of radio button
     *•	for dropdown there is a log row and value is corresponded to the selected value.
     *
     * DATA: -
     *
     * EXPECTED RESULT:
     * Log rows are displayed and
     *•	checkbox name and its status are corresponding to selected
     *•	radio button name and it status is corresponding to selected
     *•	dropdown name and selected value is corresponding to selected
     */
    public void assertActions() {
    }

    private WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public String getPageProperty(String nameOfProperty) {
        final Properties property = new Properties();
        try (final FileInputStream fis = new FileInputStream("src/test/resources/hw2/properties/exercise_2.properties"))
        {
            property.load(fis);
        } catch (FileNotFoundException e) {
            System.out.println("File with resources of page was not founded");
        } catch (IOException e) {
            System.out.println("IOException for page");
        }
        return property.getProperty(nameOfProperty);
    }
}