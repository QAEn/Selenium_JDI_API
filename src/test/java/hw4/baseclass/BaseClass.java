package hw4.baseclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static hw4.baseclass.GetProperties.NameOfProperty.*;

public class BaseClass {

    private WebDriver driver;
    private WebDriverWait wait;
    private GetProperties getExerciseProperties = new GetProperties(EXERCISE);
    private GetProperties getUserDataProperties = new GetProperties(USER_DATA);

    public BaseClass(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //STEP #1: Open test site by URL
    //DATA: https://jdi-testing.github.io/jdi-light/index.html
    //EXPECTED RESULT: Test site is opened
    public void openPage() {
        driver.get(getExerciseProperties.getResource("homePageURL"));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.tagName("html"))));
    }

    //STEP #3: Perform login
    //DATA: username: Roman, pass: Jdi1234
    //EXPECTED RESULT: User is logged
    public void login() {
        String loginCaretStr = getExerciseProperties.getResource("loginCaret");
        WebElement loginCaret = driver.findElement(By.id(loginCaretStr));
        loginCaret.click();

        String userNameDataProp = getUserDataProperties.getResource("name");
        String usernameStr = getExerciseProperties.getResource("username");
        WebElement username = driver.findElement(By.cssSelector(usernameStr));
        username.sendKeys(userNameDataProp);


        String userPassDataProp = getUserDataProperties.getResource("password");
        String passStr = getExerciseProperties.getResource("pass");
        WebElement pass = driver.findElement(By.cssSelector(passStr));
        pass.sendKeys(userPassDataProp);

        String enterBtnStr = getExerciseProperties.getResource("enterBtn");
        WebElement enterBtn = driver.findElement(By.xpath(enterBtnStr));
        enterBtn.click();
    }
}