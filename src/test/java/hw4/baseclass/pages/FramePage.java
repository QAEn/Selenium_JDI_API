package hw4.baseclass.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends AbstractPage {

    @FindBy(css = "iframe#frame")
    private WebElement iframe;
    @FindBy(css = "#frame-button")
    private WebElement iframeBtn;

    public FramePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getIframe() {
        return iframe;
    }

    public WebElement getIframeBtn() {
        return iframeBtn;
    }
}
