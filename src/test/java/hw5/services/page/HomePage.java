package hw5.services.page;

import hw5.services.entity.User;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

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

    public void openPage() {
        driver.get(getExerciseProperties.getResource("homePageURL"));
    }

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
}