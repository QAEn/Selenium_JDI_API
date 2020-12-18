package hw2.ex1.runtest;

import hw2.baseclass.CoreTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FirstExerciseRunTest extends CoreTest {

    @Test(
            description = "First exercise test, Jira binding cab be here"
    )
    public void exercise_1_Test() {

        commonSteps.baseMethod();

        //STEP #5: Assert that there are 4 items on the header section
        //         are displayed and they have proper texts
        List<WebElement> elementsHeader = driver
                .findElements(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8"));
        List<String> textsHeader = elementsHeader
                .stream().map(WebElement::getText).collect(Collectors.toList());
        softAssertion.assertEquals(textsHeader, Arrays.asList("HOME\n"
                + "CONTACT FORM\n"
                + "SERVICE\n"
                + "METALS & COLORS"));

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
        WebElement iframe = driver.findElement(By.cssSelector("iframe#frame"));
        softAssertion.assertEquals(iframe.getText(),
                "<p>Your browser does not support iframes.</p>",
                "The iframe with “Frame Button” isn't exist");

        //STEP #9: Switch to the iframe and check that there is “Frame Button” in the iframe
        WebElement switchIframe = driver.findElement(By.cssSelector("iframe#frame"));
        driver.switchTo().frame(switchIframe);
        String iframeBtnStr = "frame-button";
        String actual = driver.findElement(By.id(iframeBtnStr)).getAttribute("value");
        String expected = "Frame Button";
        softAssertion.assertEquals(actual, expected);

        //STEP #10: Switch to original window back
        driver.switchTo().defaultContent();
        softAssertion.assertTrue(headphonesImg.isDisplayed(),
                "Switch to the original window back FAILED");

        //STEP #11: Assert that there are 5 items in the Left Section
        //          are displayed and they have proper text
        List<WebElement> elements = driver.findElements(By.cssSelector("ul.sidebar-menu > li"));
        List<String> texts = elements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        softAssertion.assertEquals(texts,
        Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs"));

        softAssertion.assertAll();
    }
}