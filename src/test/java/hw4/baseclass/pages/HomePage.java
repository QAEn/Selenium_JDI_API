package hw4.baseclass.pages;

import hw4.baseclass.utility.GetProperties;
import hw4.baseclass.entity.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static hw4.baseclass.utility.GetProperties.NameOfProperty.EXERCISE;

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

    @FindBy(id = "user-icon")
    private WebElement loginCaret;

    @FindBy(css = "#name")
    private WebElement username;

    @FindBy(css = "#password")
    private WebElement pass;

    @FindBy(id = "login-button")
    private WebElement enterBtn;

    @FindBy(id = "user-name")
    private WebElement getUsername;


    private WebDriverWait wait;
    private GetProperties getExerciseProperties = new GetProperties(EXERCISE);

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver);
        this.wait = wait;
    }

    @Step("STEP #1: Open test site by URL")
    public void openPage() {
        driver.get(getExerciseProperties.getResource("homePageURL"));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.tagName("html"))));
    }

    @Step("STEP #3: Perform login")
    public void login(String userName, String password) {
        User.getInstance(userName, password);

        loginCaret.click();

        username.sendKeys(User.getName().substring(0,5));
        pass.sendKeys(User.getPassword());
        enterBtn.click();
    }

    public String getUserName() {
        return getUsername.getText();
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