package hw4.ex1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8")
    private List<WebElement> elementsHeader;

    @FindBy(css = ".icon-custom")
    private WebElement microscopeImg;
    @FindBy(css = ".icon-multi")
    private WebElement headphonesImg;
    @FindBy(css = ".icon-practise")
    private WebElement monitorImg;
    @FindBy(css = ".icon-base")
    private WebElement rocketImg;

    @FindBy(xpath = "//span[contains(text(),'To include good practices')]")
    private WebElement microscopeTxt;
    @FindBy(xpath = "//span[contains(text(),'To be flexible and')]")
    private WebElement headphonesTxt;
    @FindBy(xpath = "//span[contains(text(),'To be multiplatform')]")
    private WebElement monitorTxt;
    @FindBy(xpath = "//span[contains(text(),'Already have good base')]")
    private WebElement rocketTxt;

    @FindBy(css = "iframe#frame")
    private WebElement iframe;

    @FindBy(css = "ul.sidebar-menu")
    private List<WebElement> elementsLeft;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //STEP #10: Switch to original window back
    //DATA: -
    //EXPECTED RESULT: Driver has focus on the original window
    public void switchHomePage() {
        driver.switchTo().defaultContent();
    }

    public List<WebElement> getElementsHeader() {
        return elementsHeader;
    }

    public WebElement getMicroscopeImg() {
        return microscopeImg;
    }

    public WebElement getHeadphonesImg() {
        return headphonesImg;
    }

    public WebElement getMonitorImg() {
        return monitorImg;
    }

    public WebElement getRocketImg() {
        return rocketImg;
    }

    public WebElement getMicroscopeTxt() {
        return microscopeTxt;
    }

    public WebElement getHeadphonesTxt() {
        return headphonesTxt;
    }

    public WebElement getMonitorTxt() {
        return monitorTxt;
    }

    public WebElement getRocketTxt() {
        return rocketTxt;
    }

    public WebElement getIframe() {
        return iframe;
    }

    public List<WebElement> getElementsLeft() {
        return elementsLeft;
    }
}