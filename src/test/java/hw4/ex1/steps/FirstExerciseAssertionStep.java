package hw4.ex1.steps;

import hw4.baseclass.GetProperties;
import hw4.ex1.pages.FramePage;
import hw4.ex1.pages.HomePage;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static hw4.baseclass.GetProperties.NameOfProperty.EXERCISE_DATA;

public class FirstExerciseAssertionStep {

    private FramePage framePage;
    private WebDriver driver;
    private SoftAssert softAssertion;
    private HomePage homePage;
    private GetProperties getExerciseDataProperties = new GetProperties(EXERCISE_DATA);

    public FirstExerciseAssertionStep(WebDriver driver, SoftAssert softAssertion) {
        this.softAssertion = softAssertion;
        this.driver = driver;
        this.framePage = new FramePage(driver);
        homePage = new HomePage(driver);
    }

    //STEP #5: Assert that there are 4 items on the header
    //section are displayed and they have proper texts
    //DATA: "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
    //EXPECTED RESULT: Menu buttons are displayed and have proper texts
    @Step("STEP #5: Assert that there are 4 items on the header")
    public void assertHeaderItemsOnHomePage() {
        List<String> textsHeader = homePage.getElementsHeader()
                .stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> expected = Arrays.asList(
                getExerciseDataProperties.getResource("assertHeaderItems")
        );
        softAssertion.assertEquals(textsHeader, expected,
                "Incorrect assertHeaderItems() method");
    }

    //STEP #6: Assert that there are 4 images on the Index Page and they are displayed
    //DATA: 4 images
    //EXPECTED RESULT: Images are displayed
    @Step("STEP #6: Assert that there are 4 images on the Index Page and they are displayed")
    public void assertImagesOnHomePage() {

        //microscopeImg
        softAssertion.assertTrue(homePage.getMicroscopeImg().isDisplayed(),
                "Microscope image is not displayed");

        //headphonesImg
        softAssertion.assertTrue(homePage.getHeadphonesImg().isDisplayed(),
                "Headphones image is not displayed");

        //monitorImg
        softAssertion.assertTrue(homePage.getMonitorImg().isDisplayed(),
                "Monitor image is not displayed");

        //rocketImg
        softAssertion.assertTrue(homePage.getRocketImg().isDisplayed(),
                "Rocket image is not displayed");
    }

    //STEP #7: Assert that there are 4 texts on the Index Page under icons and they have proper text
    //DATA: 4 texts below of each image
    //EXPECTED RESULT: Texts are displayed and equal to expected
    @Step("STEP #7: Assert that there are 4 texts on the Index"
            + "Page under icons and they have proper text")
    public void assertTextOnHomePage(String expectedMicroscope, String expectedHeadphones,
                                     String expectedMonitor, String expectedRocket) {
        //microscopeTxt
        softAssertion.assertEquals(homePage.getMicroscopeTxt().getText(), expectedMicroscope,
                "Microscope text is not displayed under icon");

        //headphonesTxt
        softAssertion.assertEquals(homePage.getHeadphonesTxt().getText(), expectedHeadphones,
                "Headphone text is not displayed under icon");

        //monitorTxt
        softAssertion.assertEquals(homePage.getMonitorTxt().getText(),expectedMonitor,
                "Monitor text is not displayed under icon");

        //rocketTxt
        softAssertion.assertEquals(homePage.getRocketTxt().getText(), expectedRocket,
                "Rocket text is not displayed under icon");
    }

    //STEP #8: Assert that there is the iframe with “Frame Button” exist
    //DATA: -
    //EXPECTED RESULT: The iframe exists
    @Step("STEP #8: Assert that there is the iframe with “Frame Button” exist")
    public void iframeWithButtonExists() {
        String expected = getExerciseDataProperties
                .getResource("iframeWithButtonExists");
        softAssertion.assertEquals(homePage.getIframe().getText(), expected,
                "The iframe with “Frame Button” isn't exist");
    }

    //STEP #9: Switch to the iframe and check that there is “Frame Button” in the iframe
    //DATA: -
    //EXPECTED RESULT: The “Frame Button” exists
    @Step("STEP #9: Switch to the iframe and check that there is “Frame Button” in the iframe")
    public void frameButtonExists() {
        driver.switchTo().frame(framePage.getIframe());
        String actual = framePage.getIframeBtn().getAttribute("value");
        String expected = getExerciseDataProperties.getResource("frameButton");
        softAssertion.assertEquals(actual, expected);
    }

    //STEP #11: Assert that there are 5 items in the Left Section
    //          are displayed and they have proper text
    //DATA:  “Home”, “Contact form”, “Service”, “Metals & Colors”, “Elements packs”
    //EXPECTED RESULT: Left section menu items are displayed and have proper text
    public void assertLeftSectionItems() {
        String expected = getExerciseDataProperties
                .getResource("assertLeftSectionItems");
        List<String> texts = homePage.getElementsLeft()
                .stream().map(WebElement::getText).collect(Collectors.toList());
        softAssertion.assertEquals(texts, Arrays.asList(expected));
    }
}