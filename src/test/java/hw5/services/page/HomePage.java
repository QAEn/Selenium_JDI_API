package hw5.services.page;

import hw5.services.entity.User;
import hw5.services.page.component.Header;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//li[3]/a[1]")
    protected WebElement serviceHeaderElement;

    @FindBy(css = ".dropdown-menu > li:nth-child(8) > a")
    protected WebElement differentElements;

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

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("STEP #1: Open test site by URL")
    public void openPage() {
        driver.get(getExerciseProperties.getResource("homePageURL"));
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

    @Step("STEP #5: I click on 'Service' button in Header")
    public void clickServiceButton(String pageName) {
        serviceHeaderElement.click();
    }

    @Step("STEP #5: I click on 'Different Elements Page' button in Service dropdown")
    public void openPageFromHeader(String pageName) {
        differentElements.click();
    }

}