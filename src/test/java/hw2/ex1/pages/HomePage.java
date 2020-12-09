package hw2.ex1.pages;

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
     * STEP #4: Assert Username is logged
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
     * STEP #5: Assert that there are 4 items on the header section are displayed and they have proper texts
     * DATA: "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
     * EXPECTED RESULT: Menu buttons are displayed and have proper texts
     */
    public void assertHeaderItems() {
        //assert "HOME"
        {
            String home = getPageProperty("homeItem");
            waitForElementLocatedBy(driver, By.xpath(home));
            String actual = driver.findElement(By.xpath(home)).getText();
            String expected = "HOME";
            Assert.assertEquals(actual, expected);
        }

        //assert "CONTACT FORM"
        {
            String contactForm = getPageProperty("contactForm");
            waitForElementLocatedBy(driver, By.xpath(contactForm));
            String actual = driver.findElement(By.xpath(contactForm)).getText();
            String expected = "CONTACT FORM";
            Assert.assertEquals(actual, expected);
        }

        //assert "SERVICE"
        {
            String service = getPageProperty("service");
            waitForElementLocatedBy(driver, By.xpath(service));
            String actual = driver.findElement(By.xpath(service)).getText();
            String expected = "SERVICE";
            Assert.assertEquals(actual, expected);
        }

        //"METALS & COLORS"
        {
            String metalColors = getPageProperty("metalColors");
            waitForElementLocatedBy(driver, By.xpath(metalColors));
            String actual = driver.findElement(By.xpath(metalColors)).getText();
            String expected = "METALS & COLORS";
            Assert.assertEquals(actual, expected);
        }
    }

    /**
     * STEP #6: Assert that there are 4 images on the Index Page and they are displayed
     * DATA: 4 images
     * EXPECTED RESULT: Images are displayed
     */
    public void assertImages() {
    }

    /**
     * STEP #7: Assert that there are 4 texts on the Index Page under icons and they have proper text
     * DATA: 4 texts below of each image
     * EXPECTED RESULT: Texts are displayed and equal to expected
     */
    public void assertText() {
    }

    /**
     * STEP #8: Assert that there is the iframe with “Frame Button” exist
     * DATA: -
     * EXPECTED RESULT: The iframe exists
     */
    public void iframeWithButtonExists() {
    }

    /**
     * STEP #9: Switch to the iframe and check that there is “Frame Button” in the iframe
     * DATA: -
     * EXPECTED RESULT: The “Frame Button” exists
     */
    public void frameButtonExists() {
    }

    /**
     * STEP #10: Switch to original window back
     * DATA: -
     * EXPECTED RESULT: Driver has focus on the original window
     */
    public void switchHomePage() {
    }

    /**
     * STEP #11: Assert that there are 5 items in the Left Section are displayed and they have proper text
     * DATA:  “Home”, “Contact form”, “Service”, “Metals & Colors”, “Elements packs”
     * EXPECTED RESULT: Left section menu items are displayed and have proper text
     */
    public void assertLeftSectionItems() {
        //assert "Home"
        {
            String homeLeftSide = getPageProperty("homeLeftSide");
            waitForElementLocatedBy(driver, By.xpath(homeLeftSide));
            String actual = driver.findElement(By.xpath(homeLeftSide)).getText();
            String expected = "Home";
            Assert.assertEquals(actual, expected);
        }

        //assert "Contact form"
        {
            String contactFormLeftSide = getPageProperty("contactFormLeftSide");
            waitForElementLocatedBy(driver, By.xpath(contactFormLeftSide));
            String actual = driver.findElement(By.xpath(contactFormLeftSide)).getText();
            String expected = "Contact form";
            Assert.assertEquals(actual, expected);
        }

        //assert "Service"
        {
            String serviceLeftSide = getPageProperty("serviceLeftSide");
            waitForElementLocatedBy(driver, By.xpath(serviceLeftSide));
            String actual = driver.findElement(By.xpath(serviceLeftSide)).getText();
            String expected = "Service";
            Assert.assertEquals(actual, expected);
        }

        //"Metals & Colors"
        {
            String metalColorsLeftSide = getPageProperty("metalColorsLeftSide");
            waitForElementLocatedBy(driver, By.xpath(metalColorsLeftSide));
            String actual = driver.findElement(By.xpath(metalColorsLeftSide)).getText();
            String expected = "Metals & Colors";
            Assert.assertEquals(actual, expected);
        }

        // assert "Elements packs"
        {
            String elementsPacksLeftSide = getPageProperty("elementsPacksLeftSide");
            waitForElementLocatedBy(driver, By.xpath(elementsPacksLeftSide));
            String actual = driver.findElement(By.xpath(elementsPacksLeftSide)).getText();
            String expected = "Elements packs";
            Assert.assertEquals(actual, expected);
        }
    }

    private WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public String getPageProperty(String nameOfProperty) {
        final Properties property = new Properties();
        try (final FileInputStream fis = new FileInputStream("src/test/resources/hw2/properties/exercise_1.properties"))
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