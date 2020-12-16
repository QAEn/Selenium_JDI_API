package hw2.ex2.runtest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RunTest {

    private WebDriver driver;
    private SoftAssert softAssertion;
    private WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 5);
        softAssertion = new SoftAssert();
    }

    @Test(
            description = "Second exercise test, Jira binding cab be here"
    )
    public void exercise_2_Test() {

        //STEP #1: Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.tagName("html"))));

        //STEP #2: Assert Browser title
        softAssertion.assertEquals(driver.getTitle(), "Home Page",
                "Incorrect page title");

        //STEP #3: Perform login
        WebElement loginCaret = driver.findElement(By.xpath("//a[contains(@href, '#')]"));
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

        //STEP #5: Open through the header menu Service -> Different Elements Page
        //click Service header menu
        WebElement serviceHeaderElement = driver.findElement(By.xpath("//li[3]/a[1]"));
        serviceHeaderElement.click();

        //click Different Elements
        WebElement differentElements = driver.findElement(
                By.xpath("//a[contains(@href, 'different-elements.html')]"));
        differentElements.click();
        wait.until(ExpectedConditions.titleContains("Different Elements"));

        softAssertion.assertEquals(driver.getTitle(), "Different Elements",
                "Incorrect Different Elements page title");

        //STEP #6: Select checkboxes
        //select checkbox with parameter Water
        WebElement water = driver.findElement(By.xpath("//input[@type='checkbox']"));
        water.click();

        //select checkbox with parameter Wind
        WebElement wind = driver.findElement(By.xpath("//label[3]/input"));
        wind.click();

        //STEP #7: Select radio
        WebElement selen = driver.findElement(By.xpath("//div[3]/label[4]/input"));
        selen.click();

        //STEP #8: Select in dropdown
        WebElement dropdown = driver.findElement(By.xpath("//select"));
        dropdown.click();
        Select color = new Select(dropdown);
        color.selectByVisibleText("Yellow");

        //STEP #9: Assert that each element corresponds to itself with positive status
        //for each checkbox there is an individual log row and value
        // is corresponded to the status of checkbox

        /*List<WebElement> elements = driver
                .findElements(By.xpath("//*[@id='mCSB_2_container']/section[1]"));
        List<String> texts = elements
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat("None of elements contains sub-string",
                texts.toString(), stringContainsInOrder("Yellow", "Selen", "true"));*/

        //for Water
        WebElement assertCheckBoxWater = driver.findElement(
                By.xpath("//li[contains(text(),'Water: condition changed to true')]"));
        String actualWater = assertCheckBoxWater.getText();
        softAssertion.assertTrue(actualWater.contains("Water") && actualWater.endsWith("true"),
                "Log row and (or) value isn't corresponded to the status of Water's checkbox");

        //for Wind
        WebElement assertCheckBoxWind = driver.findElement(
                By.xpath("//li[contains(text(),'Wind: condition changed to true')]"));
        String actualWind = assertCheckBoxWind.getText();
        softAssertion.assertTrue(actualWind.contains("Wind") && actualWind.endsWith("true"),
                "Log row and (or) value isn't corresponded to the status of Wind's checkbox");

        //for radio button there is a log row and value
        //is corresponded to the status of radio button
        WebElement assertRadioBtn = driver.findElement(
                By.xpath("//li[contains(text(),'Selen')]"));
        String actualRadioBtn = assertRadioBtn.getText();
        softAssertion.assertTrue(actualRadioBtn.contains("metal")
                        && actualRadioBtn.endsWith("Selen"),
                "Log row and (or) value isn't corresponded to the status of Selen's radio button");

        //for dropdown there is a log row and value is corresponded to the selected value
        WebElement assertDropdown = driver.findElement(
                By.xpath("//li[contains(text(),'Color')]"));
        String actualDropdown = assertDropdown.getText();
        softAssertion.assertTrue(actualDropdown.contains("Colors")
                        && actualDropdown.endsWith("Yellow"),
                "Log row and (or) value isn't corresponded to the status of selected value");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        //STEP #10: Close Browser
        driver.quit();
        driver = null;
        softAssertion.assertAll();
    }
}