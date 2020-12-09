package hw2.ex2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
    public void openDifferentElements() {
        //click Service header menu
        {
            String serviceHeaderElement = getPageProperty("serviceHeaderElement"); //заменить xpath todo
            waitForElementLocatedBy(driver, By.xpath(serviceHeaderElement));
            driver.findElement(By.xpath(serviceHeaderElement)).click();
        }

        //click Different Elements
        {
            String differentElements = getPageProperty("differentElements"); //заменить xpath todo
            waitForElementLocatedBy(driver, By.xpath(differentElements));
            driver.findElement(By.xpath(differentElements)).click();
        }
    }

    /**
     * STEP #6: Select checkboxes
     * DATA: Water, Wind
     * EXPECTED RESULT: Elements are checked
     */
    public void selectCheckboxes() {
        //select checkbox with parameter Water
        {
            String water = getPageProperty("water"); //заменить xpath todo
            waitForElementLocatedBy(driver, By.xpath(water));
            driver.findElement(By.xpath(water)).click();
        }
        //select checkbox with parameter Wind
        {
            String wind = getPageProperty("wind"); //заменить xpath todo
            waitForElementLocatedBy(driver, By.xpath(wind));
            driver.findElement(By.xpath(wind)).click();
        }
    }

    /**
     * STEP #7: Select radio
     * DATA: Selen
     * EXPECTED RESULT: Element is checked
     */
    public void selectRadio() {
        String selen = getPageProperty("selen"); //заменить xpath todo
        waitForElementLocatedBy(driver, By.xpath(selen));
        driver.findElement(By.xpath(selen)).click();
    }

    /**
     * STEP #8: Select in dropdown
     * DATA: Yellow
     * EXPECTED RESULT: Element is selected
     */
    public void selectInDropdown() {
        String dropdown = getPageProperty("dropdown"); //заменить xpath todo
        Select color = new Select(driver.findElement(By.xpath(dropdown)));
        color.selectByVisibleText("Yellow");
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
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        {
            //for Water
            String assertCheckBoxWater = getPageProperty("assertCheckBoxWater"); //заменить xpath todo
            waitForElementLocatedBy(driver, By.xpath(assertCheckBoxWater));
            String actualWater = driver.findElement(By.xpath(assertCheckBoxWater)).getText();
            Assert.assertTrue(actualWater.contains("Water") && actualWater.endsWith("true"));

            //for Wind
            String assertCheckBoxWind = getPageProperty("assertCheckBoxWind"); //заменить xpath todo
            waitForElementLocatedBy(driver, By.xpath(assertCheckBoxWind));
            String actualWind = driver.findElement(By.xpath(assertCheckBoxWind)).getText();
            Assert.assertTrue(actualWind.contains("Wind") && actualWind.endsWith("true"));
        }

        //for radio button there is a log row and value is corresponded to the status of radio button
        {
            String assertRadioBtn = getPageProperty("assertRadioBtn"); //заменить xpath todo
            waitForElementLocatedBy(driver, By.xpath(assertRadioBtn));
            String actual = driver.findElement(By.xpath(assertRadioBtn)).getText();
            Assert.assertTrue(actual.contains("metal") && actual.endsWith("Selen")); //В требованиях ожидается статус, а фактически явного слова true или какого-либо другого признака, указывающего на состояние в строке ответа нет
        }
        //for dropdown there is a log row and value is corresponded to the selected value
        {
            String assertDropdown = getPageProperty("assertDropdown"); //заменить xpath todo
            waitForElementLocatedBy(driver, By.xpath(assertDropdown));
            String actual = driver.findElement(By.xpath(assertDropdown)).getText();
            Assert.assertTrue(actual.contains("Colors") && actual.endsWith("Yellow"));
        }
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
