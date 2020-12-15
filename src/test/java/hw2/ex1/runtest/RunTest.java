package hw2.ex1.runtest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
        wait = new WebDriverWait(driver, 10);
        softAssertion = new SoftAssert();
    }

    @Test(
            description = "First exercise test, Jira binding cab be here"
    )
    public void exercise_1_Test() {
        //STEP #1: Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        wait.until(ExpectedConditions.presenceOfElementLocated((By.tagName("html"))));

        //STEP #2: Assert Browser title
        softAssertion.assertEquals(driver.getTitle(), "Home Page",
                "Incorrect Home page title");

        //STEP #3: Perform login
        WebElement loginCaret = driver.findElement(By.xpath("//a[contains(@href, '#')]"));
        loginCaret.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#name")));
        WebElement username = driver.findElement(By.cssSelector("#name"));
        username.sendKeys("Roman");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#password")));
        WebElement pass = driver.findElement(By.cssSelector("#password"));
        pass.sendKeys("Jdi1234");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Enter']")));
        WebElement enterBtn = driver.findElement(By.xpath("//*[text()='Enter']"));
        enterBtn.click();

        //STEP #4: Assert Username is logged
        WebElement userName = driver.findElement(By.cssSelector("#user-name"));
        softAssertion.assertEquals(userName.getText(), "ROMAN IOVLEV",
                "Incorrect username");

        //STEP #5: Assert that there are 4 items on the header section
        //         are displayed and they have proper texts

        //assert "HOME"
        WebElement home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
        softAssertion.assertEquals(home.getText(), "HOME",
                "Incorrect HOME item on the header section");

        //assert "CONTACT FORM"
        WebElement contactForm = driver.findElement(
                By.xpath("//a[contains(text(),'Contact form')]"));
        softAssertion.assertEquals(contactForm.getText(), "CONTACT FORM",
                "Incorrect CONTACT FORM item on the header section");

        //assert "SERVICE"
        WebElement service = driver.findElement(By.xpath("//a[contains(text(),'Service')]"));
        softAssertion.assertEquals(service.getText(), "SERVICE",
                "Incorrect SERVICE item on the header section");

        //"METALS & COLORS"
        WebElement metalColors = driver.findElement(
                By.xpath("//a[contains(text(),'Metals & Colors')]"));
        softAssertion.assertEquals(metalColors.getText(), "METALS & COLORS",
                "Incorrect METALS & COLORS item on the header section");

        //STEP #6: Assert that there are 4 images on the Index Page and they are displayed
        //microscopeImg
        WebElement microscopeImg = driver.findElement(By.cssSelector(".icon-practise"));
        softAssertion.assertTrue(microscopeImg.isDisplayed(),
                "Microscope image is not displayed");

        //headphonesImg
        WebElement headphonesImg = driver.findElement(By.cssSelector(".icon-custom"));
        softAssertion.assertTrue(headphonesImg.isDisplayed(),
                "Headphones image is not displayed");

        //monitorImg
        WebElement monitorImg = driver.findElement(By.cssSelector(".icon-multi"));
        softAssertion.assertTrue(monitorImg.isDisplayed(),
                "Monitor image is not displayed");

        //rocketImg
        WebElement rocketImg = driver.findElement(By.cssSelector(".icon-base"));
        softAssertion.assertTrue(rocketImg.isDisplayed(),
                "Rocket image is not displayed");

        //STEP #7: Assert that there are 4 texts on the Index Page
        //         under icons and they have proper text
        //microscopeTxt
        WebElement microscopeTxt = driver.findElement(
                By.xpath("//span[contains(text(),'To include good practices')]"));
        softAssertion.assertEquals(microscopeTxt.getText(),
                "To include good practices\n"
                        + "and ideas from successful\n"
                        + "EPAM project",
                "Microscope text is not displayed under icon");

        //headphonesTxt
        WebElement headphonesTxt = driver.findElement(
                By.xpath("//span[contains(text(),'To be flexible and')]"));
        softAssertion.assertEquals(headphonesTxt.getText(),
                "To be flexible and\n"
                        + "customizable",
                "Headphone text is not displayed under icon");

        //monitorTxt
        WebElement monitorTxt = driver.findElement(
                By.xpath("//span[contains(text(),'To be multiplatform')]"));
        softAssertion.assertEquals(monitorTxt.getText(),
                "To be multiplatform",
                "Monitor text is not displayed under icon");

        //rocketTxt
        WebElement rocketTxt = driver.findElement(
                By.xpath("//span[contains(text(),'Already have good base')]"));
        softAssertion.assertEquals(rocketTxt.getText(),
                "Already have good base\n"
                        + "(about 20 internal and\n"
                        + "some external projects),\n"
                        + "wish to get more…",
                "Rocket text is not displayed under icon");

        //STEP #8: Assert that there is the iframe with “Frame Button” exist
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='frame']"));
        Assert.assertEquals(iframe.getText(),
                "<p>Your browser does not support iframes.</p>",
                "The iframe with “Frame Button” isn't exist");

        //STEP #9: Switch to the iframe and check that there is “Frame Button” in the iframe
        WebElement switchIframe = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(switchIframe);
        String iframeBtnStr = "//input[@id='frame-button']";
        String actual = driver.findElement(By.xpath(iframeBtnStr)).getAttribute("value");
        String expected = "Frame Button";
        softAssertion.assertEquals(actual, expected);

        //STEP #10: Switch to original window back
        driver.switchTo().defaultContent();
        softAssertion.assertTrue(headphonesImg.isDisplayed(),
                "Switch to the original window back FAILED");

        //STEP #11: Assert that there are 5 items in the Left Section
        //          are displayed and they have proper text

        //assert "Home"
        WebElement homeLeftSide = driver.findElement(By.xpath("//span[contains(.,'Home')]"));
        softAssertion.assertEquals(homeLeftSide.getText(), "Home",
                "Home item in the left section is not displayed");

        //assert "Contact form"
        WebElement contactFormLeftSide = driver.findElement(
                By.xpath("//span[contains(.,'Contact form')]"));
        softAssertion.assertEquals(contactFormLeftSide.getText(), "Contact form",
                "Contact form item is not displayed in the left section");

        //assert "Service"
        WebElement serviceLeftSide = driver.findElement(By.xpath("//span[contains(.,'Service')]"));
        softAssertion.assertEquals(serviceLeftSide.getText(),"Service",
                "Service form item is not displayed in the left section");

        //"Metals & Colors"
        WebElement metalColorsLeftSide = driver.findElement(
                By.xpath("//span[contains(.,'Metals & Colors')]"));
        softAssertion.assertEquals(metalColorsLeftSide.getText(), "Metals & Colors",
                "Metals & Colors form item is not displayed in the left section");

        // assert "Elements packs"
        WebElement elementsPacksLeftSide = driver.findElement(
                By.xpath("//span[contains(.,'Elements packs')]"));
        softAssertion.assertEquals(elementsPacksLeftSide.getText(), "Elements packs",
                "Elements packs form item is not displayed in the left section");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        //STEP #12: Close Browser
        driver.quit();
        driver = null;
        softAssertion.assertAll();
    }
}