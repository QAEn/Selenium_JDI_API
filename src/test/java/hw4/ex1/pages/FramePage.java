package hw4.ex1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage extends AbstractPage {

    @FindBy(css = "iframe#frame")
    private WebElement iframe;
    @FindBy(css = "#frame-button")
    private WebElement iframeBtn;

    public FramePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getIframe() {
        return iframe;
    }

    public WebElement getIframeBtn() {
        return iframeBtn;
    }
}
