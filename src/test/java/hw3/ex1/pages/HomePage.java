package hw3.ex1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver, SoftAssert softAssertion) {
        this.driver = driver;
        this.softAssertion = softAssertion;
    }

    //STEP #5: Assert that there are 4 items on the header
    //section are displayed and they have proper texts
    //DATA: "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
    //EXPECTED RESULT: Menu buttons are displayed and have proper texts
    public void assertHeaderItems() {
        String elementsHeaderProperty = getProperties.getResource("elementsHeader");
        List<WebElement> elementsHeader = driver
                .findElements(By.cssSelector(elementsHeaderProperty));
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
        String microscopeImgProperty = getProperties.getResource("microscopeImg");
        WebElement microscopeImg = driver.findElement(By.cssSelector(microscopeImgProperty));
        softAssertion.assertTrue(microscopeImg.isDisplayed(),
                "Microscope image is not displayed");

        //headphonesImg
        String headphonesProperty = getProperties.getResource("headphonesImg");
        WebElement headphonesImg = driver.findElement(By.cssSelector(headphonesProperty));
        softAssertion.assertTrue(headphonesImg.isDisplayed(),
                "Headphones image is not displayed");

        //monitorImg
        String monitorProperty = getProperties.getResource("monitorImg");
        WebElement monitorImg = driver.findElement(By.cssSelector(monitorProperty));
        softAssertion.assertTrue(monitorImg.isDisplayed(),
                "Monitor image is not displayed");

        //rocketImg
        String rocketProperty = getProperties.getResource("rocketImg");
        WebElement rocketImg = driver.findElement(By.cssSelector(rocketProperty));
        softAssertion.assertTrue(rocketImg.isDisplayed(),
                "Rocket image is not displayed");
    }

    //STEP #7: Assert that there are 4 texts on the Index Page under icons and they have proper text
    //DATA: 4 texts below of each image
    //EXPECTED RESULT: Texts are displayed and equal to expected
    public void assertText() {
        //microscopeTxt
        String microscopeProperty = getProperties.getResource("microscopeTxt");
        WebElement microscopeTxt = driver.findElement(By.xpath(microscopeProperty));
        softAssertion.assertEquals(microscopeTxt.getText(),
                "To include good practices\n"
                        + "and ideas from successful\n"
                        + "EPAM project",
                "Microscope text is not displayed under icon");

        //headphonesTxt
        String headphonesProperty = getProperties.getResource("headphonesTxt");
        WebElement headphonesTxt = driver.findElement(By.xpath(headphonesProperty));
        softAssertion.assertEquals(headphonesTxt.getText(),
                "To be flexible and\n"
                        + "customizable",
                "Headphone text is not displayed under icon");

        //monitorTxt
        String monitorProperty = getProperties.getResource("monitorTxt");
        WebElement monitorTxt = driver.findElement(By.xpath(monitorProperty));
        softAssertion.assertEquals(monitorTxt.getText(),
                "To be multiplatform",
                "Monitor text is not displayed under icon");

        //rocketTxt
        String rocketProperty = getProperties.getResource("rocketTxt");
        WebElement rocketTxt = driver.findElement(By.xpath(rocketProperty));
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
        String iframeProperty = getProperties.getResource("iframe");
        WebElement iframe = driver.findElement(By.cssSelector(iframeProperty));
        softAssertion.assertEquals(iframe.getText(),
                "<p>Your browser does not support iframes.</p>",
                "The iframe with “Frame Button” isn't exist");
    }

    //     * STEP #9: Switch to the iframe and check that there is “Frame Button” in the iframe
    //     * DATA: -
    //     * EXPECTED RESULT: The “Frame Button” exists
    public void frameButtonExists() {
        String iframeProperty = getProperties.getResource("iframe");
        WebElement switchIframe = driver.findElement(By.cssSelector(iframeProperty));
        driver.switchTo().frame(switchIframe);
        String iframeBtnStr = getProperties.getResource("iframeBtn");
        String actual = driver.findElement(By.id(iframeBtnStr)).getAttribute("value");
        String expected = "Frame Button";
        softAssertion.assertEquals(actual, expected);
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
        String iframeBtnStr = getProperties.getResource("elementsLeft");
        List<WebElement> elements = driver
                .findElements(By.cssSelector(iframeBtnStr));
        List<String> texts = elements
                .stream().map(WebElement::getText).collect(Collectors.toList());
        softAssertion.assertEquals(texts, Arrays.asList("Home\n" + "Contact form\n" + "Service\n"
                + "Metals & Colors\n" + "Elements packs"));
        }
}