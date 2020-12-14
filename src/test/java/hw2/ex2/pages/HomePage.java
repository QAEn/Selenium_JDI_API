package hw2.ex2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //STEP #1: Open test site by URL
    //DATA: https://jdi-testing.github.io/jdi-light/index.html
    //EXPECTED RESULT: Test site is opened
    @Override
    public void openPage() {
        driver.get(getProperties.getResource("homePageURL"));
    }

    //STEP #2: Assert Browser title
    //DATA: "Home Page"
    //EXPECTED RESULT: Browser title equals "Home Page"
    @Override
    public void checkTitle() {
        Assert.assertEquals(driver.getTitle(), "Home Page");
    }

    //STEP #3: Perform login
    //DATA: username: Roman, pass: Jdi1234
    //EXPECTED RESULT: User is logged
    public void login() {
        String loginCaret = getProperties.getResource("loginCaret");
        waitForElementLocatedBy(driver, By.xpath(loginCaret)).click();

        String username = getProperties.getResource("username");
        waitForElementLocatedBy(driver, By.cssSelector(username)).sendKeys("Roman");

        String pass = getProperties.getResource("pass");
        waitForElementLocatedBy(driver, By.cssSelector(pass)).sendKeys("Jdi1234");

        String enterBtn = getProperties.getResource("enterBtn");
        waitForElementLocatedBy(driver, By.xpath(enterBtn)).click();
    }

    //STEP #4: Assert User name that user is logged
    //DATA: "ROMAN IOVLEV"
    //EXPECTED RESULT: Name is displayed and equals to expected result
    public void assertUserName() {
        String assertUserName = getProperties.getResource("assertUserName");
        String actual = waitForElementLocatedBy(driver, By.cssSelector(assertUserName)).getText();
        String expected = "ROMAN IOVLEV";
        Assert.assertEquals(actual, expected);
    }

    //STEP #5: Open through the header menu Service -> Different Elements Page
    //DATA:
    //EXPECTED RESULT: Page is opened
    public void openDifferentElements() {
        //click Service header menu
        String serviceHeaderElement = getProperties.getResource("serviceHeaderElement");
        waitForElementLocatedBy(driver, By.xpath(serviceHeaderElement)).click();

        //click Different Elements
        String differentElements = getProperties.getResource("differentElements");
        waitForElementLocatedBy(driver, By.xpath(differentElements)).click();
    }

    //STEP #6: Select checkboxes
    //DATA: Water, Wind
    //EXPECTED RESULT: Elements are checked
    public void selectCheckboxes() {
        //select checkbox with parameter Water
        String water = getProperties.getResource("water");
        waitForElementLocatedBy(driver, By.xpath(water)).click();

        //select checkbox with parameter Wind
        String wind = getProperties.getResource("wind");
        waitForElementLocatedBy(driver, By.xpath(wind)).click();
    }

    //STEP #7: Select radio
    //DATA: Selen
    //EXPECTED RESULT: Element is checked
    public void selectRadio() {
        String selen = getProperties.getResource("selen");
        waitForElementLocatedBy(driver, By.xpath(selen)).click();
    }

    //STEP #8: Select in dropdown
    //DATA: Yellow
    //EXPECTED RESULT: Element is selected
    public void selectInDropdown() {
        String dropdown = getProperties.getResource("dropdown");
        Select color = new Select(waitForElementLocatedBy(driver, By.xpath(dropdown)));
        color.selectByVisibleText("Yellow");
    }

    //STEP #9:
    //Assert that:
    //-for each checkbox there is an individual log row and
    // value is corresponded to the status of checkbox
    //-for radio button there is a log row and value is corresponded to the status of radio button
    //-for dropdown there is a log row and value is corresponded to the selected value.
    //DATA: -
    //EXPECTED RESULT:
    //Log rows are displayed and
    //-checkbox name and its status are corresponding to selected
    //-radio button name and it status is corresponding to selected
    //-dropdown name and selected value is corresponding to selected
    public void assertActions() {
        //for each checkbox there is an individual log row and
        // value is corresponded to the status of checkbox
        //for Water
        String assertCheckBoxWater = getProperties.getResource("assertCheckBoxWater");
        String actualWater = waitForElementLocatedBy(driver, By.xpath(assertCheckBoxWater))
                                                                                .getText();
        Assert.assertTrue(actualWater.contains("Water") && actualWater.endsWith("true"));

        //for Wind
        String assertCheckBoxWind = getProperties.getResource("assertCheckBoxWind");
        String actualWind = waitForElementLocatedBy(driver, By.xpath(assertCheckBoxWind)).getText();
        Assert.assertTrue(actualWind.contains("Wind") && actualWind.endsWith("true"));

        //for radio button there is a log row and value
        // is corresponded to the status of radio button
        String assertRadioBtn = getProperties.getResource("assertRadioBtn");
        String actualRadioBtn = waitForElementLocatedBy(driver, By.xpath(assertRadioBtn)).getText();
        Assert.assertTrue(actualRadioBtn.contains("metal") && actualRadioBtn.endsWith("Selen"));

        //for dropdown there is a log row and value is corresponded to the selected value
        String assertDropdown = getProperties.getResource("assertDropdown");
        String actual = waitForElementLocatedBy(driver, By.xpath(assertDropdown)).getText();
        Assert.assertTrue(actual.contains("Colors") && actual.endsWith("Yellow"));
    }
}