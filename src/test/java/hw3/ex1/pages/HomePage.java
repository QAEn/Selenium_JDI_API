package hw3.ex1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends AbstractPage {

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8")
    List<WebElement> elementsHeader;

    @FindBy(css = ".icon-custom")
    WebElement microscopeImg;
    @FindBy(css = ".icon-multi")
    WebElement headphonesImg;
    @FindBy(css = ".icon-practise")
    WebElement monitorImg;
    @FindBy(css = ".icon-base")
    WebElement rocketImg;

    @FindBy(xpath = "//span[contains(text(),'To include good practices')]")
    WebElement microscopeTxt;
    @FindBy(xpath = "//span[contains(text(),'To be flexible and')]")
    WebElement headphonesTxt;
    @FindBy(xpath = "//span[contains(text(),'To be multiplatform')]")
    WebElement monitorTxt;
    @FindBy(xpath = "//span[contains(text(),'Already have good base')]")
    WebElement rocketTxt;

    @FindBy(css = "iframe#frame")
    WebElement iframe;

    @FindBy(css = "ul.sidebar-menu")
    List<WebElement> elementsLeft;

    public HomePage(WebDriver driver, SoftAssert softAssertion) {
        super(driver, softAssertion);
        PageFactory.initElements(driver, this);
    }

    //STEP #5: Assert that there are 4 items on the header
    //section are displayed and they have proper texts
    //DATA: "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
    //EXPECTED RESULT: Menu buttons are displayed and have proper texts
    public void assertHeaderItems() {
        List<String> textsHeader = elementsHeader
                .stream().map(WebElement::getText).collect(Collectors.toList());
        softAssertion.assertEquals(textsHeader, Arrays.asList("HOME\n"
                + "CONTACT FORM\n"
                + "SERVICE\n"
                + "METALS & COLORS"));
    }

    //STEP #6: Assert that there are 4 images on the Index Page and they are displayed
    //DATA: 4 images
    //EXPECTED RESULT: Images are displayed
    public void assertImages() {
        //microscopeImg
        softAssertion.assertTrue(microscopeImg.isDisplayed(),
                "Microscope image is not displayed");

        //headphonesImg
        softAssertion.assertTrue(headphonesImg.isDisplayed(),
                "Headphones image is not displayed");

        //monitorImg
        softAssertion.assertTrue(monitorImg.isDisplayed(),
                "Monitor image is not displayed");

        //rocketImg
        softAssertion.assertTrue(rocketImg.isDisplayed(),
                "Rocket image is not displayed");
    }

    //STEP #7: Assert that there are 4 texts on the Index Page under icons and they have proper text
    //DATA: 4 texts below of each image
    //EXPECTED RESULT: Texts are displayed and equal to expected
    public void assertText() {
        //microscopeTxt
        softAssertion.assertEquals(microscopeTxt.getText(),
                "To include good practices\n"
                        + "and ideas from successful\n"
                        + "EPAM project",
                "Microscope text is not displayed under icon");

        //headphonesTxt
        softAssertion.assertEquals(headphonesTxt.getText(),
                "To be flexible and\n"
                        + "customizable",
                "Headphone text is not displayed under icon");

        //monitorTxt
        softAssertion.assertEquals(monitorTxt.getText(),
                "To be multiplatform",
                "Monitor text is not displayed under icon");

        //rocketTxt
        softAssertion.assertEquals(rocketTxt.getText(),
                "Already have good base\n"
                        + "(about 20 internal and\n"
                        + "some external projects),\n"
                        + "wish to get more…",
                "Rocket text is not displayed under icon");
    }

    //STEP #8: Assert that there is the iframe with “Frame Button” exist
    //DATA: -
    //EXPECTED RESULT: The iframe exists
    public void iframeWithButtonExists() {
        softAssertion.assertEquals(iframe.getText(),
                "<p>Your browser does not support iframes.</p>",
                "The iframe with “Frame Button” isn't exist");
    }

    //STEP #10: Switch to original window back
    //DATA: -
    //EXPECTED RESULT: Driver has focus on the original window
    public void switchHomePage() {
        driver.switchTo().defaultContent();
    }

    //STEP #11: Assert that there are 5 items in the Left Section
    //          are displayed and they have proper text
    //DATA:  “Home”, “Contact form”, “Service”, “Metals & Colors”, “Elements packs”
    //EXPECTED RESULT: Left section menu items are displayed and have proper text
    public void assertLeftSectionItems() {
        List<String> texts = elementsLeft
                .stream().map(WebElement::getText).collect(Collectors.toList());
        softAssertion.assertEquals(texts, Arrays.asList("Home\n" + "Contact form\n" + "Service\n"
                + "Metals & Colors\n" + "Elements packs"));
        }
}