package hw2.ex1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends AbstractPage {

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
    public void checkTitle() {
        Assert.assertEquals(driver.getTitle(), "Home Page");
    }

    /**
     * STEP #3: Perform login
     * DATA: username: Roman, pass: Jdi1234
     * EXPECTED RESULT: User is logged
     */
    public void login() {
        String loginCaret = getPageProperty("loginCaret"); //xpath todo
        waitForElementLocatedBy(driver, By.xpath(loginCaret)).click();

        String username = getPageProperty("username");
        waitForElementLocatedBy(driver, By.cssSelector(username)).sendKeys("Roman");

        String pass = getPageProperty("pass");
        waitForElementLocatedBy(driver, By.cssSelector(pass)).sendKeys("Jdi1234");

        String enterBtn = getPageProperty("enterBtn");
        waitForElementLocatedBy(driver, By.xpath(enterBtn)).click();
    }

    /**
     * STEP #4: Assert Username is logged
     * DATA: "ROMAN IOVLEV"
     * EXPECTED RESULT: Name is displayed and equals to expected result
     */
    public void assertUserName() {
        String assertUserName = getPageProperty("assertUserName");
        String actual = waitForElementLocatedBy(driver, By.cssSelector(assertUserName)).getText();
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
        String home = getPageProperty("homeItem");
        Assert.assertEquals(waitForElementLocatedBy(driver, By.xpath(home)).getText(), "HOME");

        //assert "CONTACT FORM"
        String contactForm = getPageProperty("contactForm");
        Assert.assertEquals(waitForElementLocatedBy(driver, By.xpath(contactForm)).getText(), "CONTACT FORM");

        //assert "SERVICE"
        String service = getPageProperty("service");
        Assert.assertEquals(waitForElementLocatedBy(driver, By.xpath(service)).getText(), "SERVICE");

        //"METALS & COLORS"
        String metalColors = getPageProperty("metalColors");
        Assert.assertEquals(waitForElementLocatedBy(driver, By.xpath(metalColors)).getText(), "METALS & COLORS");
    }

    /**
     * STEP #6: Assert that there are 4 images on the Index Page and they are displayed
     * DATA: 4 images
     * EXPECTED RESULT: Images are displayed
     */
    public void assertImages() {
        //microscopeImg
        String microscopeImg = getPageProperty("microscopeImg");
        Assert.assertTrue(waitForElementLocatedBy(driver, By.xpath(microscopeImg)).isDisplayed());

        //headphonesImg
        String headphonesImg = getPageProperty("headphonesImg");
        Assert.assertTrue(waitForElementLocatedBy(driver, By.xpath(headphonesImg)).isDisplayed());

        //monitorImg
        String monitorImg = getPageProperty("monitorImg");
        Assert.assertTrue(waitForElementLocatedBy(driver, By.xpath(monitorImg)).isDisplayed());

        //rocketImg
        String rocketImg = getPageProperty("rocketImg");;
        Assert.assertTrue(waitForElementLocatedBy(driver, By.xpath(rocketImg)).isDisplayed());
    }

    /**
     * STEP #7: Assert that there are 4 texts on the Index Page under icons and they have proper text
     * DATA: 4 texts below of each image
     * EXPECTED RESULT: Texts are displayed and equal to expected
     */
    public void assertText() {
        //microscopeTxt
        String microscopeTxt = getPageProperty("microscopeTxt");
        Assert.assertEquals(waitForElementLocatedBy(driver, By.xpath(microscopeTxt)).getText(),
                            "To include good practices\n" + "and ideas from successful\n" + "EPAM project");

        //headphonesTxt
        String headphonesTxt = getPageProperty("headphonesTxt");
        Assert.assertEquals(waitForElementLocatedBy(driver, By.xpath(headphonesTxt)).getText(),
                            "To be flexible and\n" + "customizable");

        //monitorTxt
        String monitorTxt = getPageProperty("monitorTxt");
        Assert.assertEquals(waitForElementLocatedBy(driver, By.xpath(monitorTxt)).getText(),
                            "To be multiplatform");

        //rocketTxt
        String rocketTxt = getPageProperty("rocketTxt");
        Assert.assertEquals(waitForElementLocatedBy(driver, By.xpath(rocketTxt)).getText(),
                "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");
    }

    /**
     * STEP #8: Assert that there is the iframe with “Frame Button” exist
     * DATA: -
     * EXPECTED RESULT: The iframe exists
     */
    public void iframeWithButtonExists() {
        String iframe = getPageProperty("iframe");
        Assert.assertEquals(waitForElementLocatedBy(driver, By.xpath(iframe)).getText(),
                "<p>Your browser does not support iframes.</p>");
    }

    /**
     * STEP #9: Switch to the iframe and check that there is “Frame Button” in the iframe
     * DATA: -
     * EXPECTED RESULT: The “Frame Button” exists
     */

    public void frameButtonExists() {
        String iframe = getPageProperty("iframe");
        driver.switchTo().frame(waitForElementLocatedBy(driver, By.xpath(iframe)));
        String iframeBtn = getPageProperty("iframeBtn");
        String actual = waitForElementLocatedBy(driver, By.xpath(iframeBtn)).getAttribute("value");
        String expected = "Frame Button";
        Assert.assertEquals(actual, expected);
    }

    /**
     * STEP #10: Switch to original window back
     * DATA: -
     * EXPECTED RESULT: Driver has focus on the original window
     */
    public void switchHomePage() {
        driver.switchTo().defaultContent();
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
            String actual = waitForElementLocatedBy(driver, By.xpath(homeLeftSide)).getText();
            String expected = "Home";
            Assert.assertEquals(actual, expected);
        }

        //assert "Contact form"
        {
            String contactFormLeftSide = getPageProperty("contactFormLeftSide");
            String actual = waitForElementLocatedBy(driver, By.xpath(contactFormLeftSide)).getText();
            String expected = "Contact form";
            Assert.assertEquals(actual, expected);
        }

        //assert "Service"
        {
            String serviceLeftSide = getPageProperty("serviceLeftSide");
            String actual = waitForElementLocatedBy(driver, By.xpath(serviceLeftSide)).getText();
            String expected = "Service";
            Assert.assertEquals(actual, expected);
        }

        //"Metals & Colors"
        {
            String metalColorsLeftSide = getPageProperty("metalColorsLeftSide");
            String actual = waitForElementLocatedBy(driver, By.xpath(metalColorsLeftSide)).getText();
            String expected = "Metals & Colors";
            Assert.assertEquals(actual, expected);
        }

        // assert "Elements packs"
        {
            String elementsPacksLeftSide = getPageProperty("elementsPacksLeftSide");
            String actual = waitForElementLocatedBy(driver, By.xpath(elementsPacksLeftSide)).getText();
            String expected = "Elements packs";
            Assert.assertEquals(actual, expected);
        }
    }
}