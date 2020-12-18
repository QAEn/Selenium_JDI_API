package hw3.ex1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class FramePage extends AbstractPage {

    @FindBy(css = "iframe#frame")
    WebElement iframe;
    @FindBy(css = "#frame-button")
    WebElement iframeBtn;

    public FramePage(WebDriver driver, SoftAssert softAssertion) {
        super(driver, softAssertion);
        PageFactory.initElements(driver, this);
    }

    //     * STEP #9: Switch to the iframe and check that there is “Frame Button” in the iframe
    //     * DATA: -
    //     * EXPECTED RESULT: The “Frame Button” exists
    public void frameButtonExists() {
        driver.switchTo().frame(iframe);
        String actual = iframeBtn.getAttribute("value");
        String expected = "Frame Button";
        softAssertion.assertEquals(actual, expected);
    }
}
