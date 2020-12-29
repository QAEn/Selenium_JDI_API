package hw4.baseclass.steps.assertion;

import hw4.baseclass.utility.GetProperties;
import hw4.baseclass.pages.FramePage;
import hw4.baseclass.pages.HomePage;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.util.Arrays;
import java.util.List;
import static hw4.baseclass.utility.GetProperties.NameOfProperty.EXERCISE_DATA;

public class FirstExerciseAssertionStep {

    private FramePage framePage;
    private WebDriver driver;
    private SoftAssert softAssertion;
    private HomePage homePage;
    private GetProperties getExerciseDataProperties = new GetProperties(EXERCISE_DATA);

    public FirstExerciseAssertionStep(WebDriver driver, SoftAssert softAssertion,
                                      WebDriverWait wait) {
        this.softAssertion = softAssertion;
        this.driver = driver;
        framePage = new FramePage(driver);
        homePage = new HomePage(driver, wait);
    }

    @Step("STEP #5: Assert that there are 4 items on the header")
    public void assertHeaderItemsOnHomePage(List<String> actual, List<String> expected) {
        softAssertion.assertEquals(actual, expected,
                "Incorrect assertHeaderItems() method");
    }

    @Step("STEP #6: Assert that there are 4 images on the Index Page and they are displayed")
    public void assertImagesOnHomePage(Boolean microscopeImg, Boolean headphonesImg,
                                       Boolean monitorImg, Boolean rocketImg) {

        softAssertion.assertTrue(microscopeImg,"Microscope image is not displayed");
        softAssertion.assertTrue(headphonesImg,"Headphones image is not displayed");
        softAssertion.assertTrue(monitorImg,"Monitor image is not displayed");
        softAssertion.assertTrue(rocketImg,"Rocket image is not displayed");
    }

    @Step("STEP #7: Assert that there are 4 texts on the Index"
            + "Page under icons and they have proper text")
    public void assertTextOnHomePage(String expectedMicroscope, String expectedHeadphones,
                                     String expectedMonitor, String expectedRocket) {

        softAssertion.assertEquals(homePage.getMicroscopeTxt().getText(), expectedMicroscope,
                "Microscope text is not displayed under icon");

        softAssertion.assertEquals(homePage.getHeadphonesTxt().getText(), expectedHeadphones,
                "Headphone text is not displayed under icon");

        softAssertion.assertEquals(homePage.getMonitorTxt().getText(),expectedMonitor,
                "Monitor text is not displayed under icon");

        softAssertion.assertEquals(homePage.getRocketTxt().getText(), expectedRocket,
                "Rocket text is not displayed under icon");
    }

    @Step("STEP #8: Assert that there is the iframe with “Frame Button” exist")
    public void assertIframeWithButtonExists(String actual, String expected) {
        softAssertion.assertEquals(actual, expected,
                "The iframe with “Frame Button” isn't exist");
    }

    @Step("STEP #9: Switch to the iframe and check that there is “Frame Button” in the iframe")
    public void frameButtonExists() {
        driver.switchTo().frame(framePage.getIframe());
        String actual = framePage.getIframeBtn().getAttribute("value");
        String expected = getExerciseDataProperties.getResource("frameButton");
        softAssertion.assertEquals(actual, expected);
    }

    @Step("STEP #11: Assert that there are 5 items in the Left Section")
    public void assertLeftSectionItems(List actual, String expected) {
        softAssertion.assertEquals(actual, Arrays.asList(expected));
    }
}