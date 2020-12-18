package hw3.baseclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import static hw3.baseclass.GetProperties.NameOfProperty.EXERCISE;
import static hw3.baseclass.GetProperties.NameOfProperty.USER_DATA;

public class BaseClass {

    private WebDriver driver;
    private SoftAssert softAssertion;
    private WebDriverWait wait;
    private GetProperties getExerciseProperties = new GetProperties(EXERCISE);
    private GetProperties getUserDataProperties = new GetProperties(USER_DATA);

    public BaseClass(WebDriver driver, SoftAssert softAssertion, WebDriverWait wait) {
        this.driver = driver;
        this.softAssertion = softAssertion;
        this.wait = wait;
    }

    //STEP #1: Open test site by URL
    //DATA: https://jdi-testing.github.io/jdi-light/index.html
    //EXPECTED RESULT: Test site is opened
    public void openPage() {
        driver.get(getExerciseProperties.getResource("homePageURL"));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.tagName("html"))));
    }

    //STEP #2: Assert Browser title
    //DATA: "Home Page"
    //EXPECTED RESULT: Browser title equals "Home Page"
    public void checkTitle() {
        softAssertion.assertEquals(driver.getTitle(), "Home Page",
                "Incorrect page title");
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

    //STEP #4: Assert Username is logged
    //DATA: "ROMAN IOVLEV"
    //EXPECTED RESULT: Name is displayed and equals to expected result
    public void assertUserName() {
        String assertUserName = getExerciseProperties.getResource("assertUserName");
        WebElement userName = driver.findElement(By.cssSelector(assertUserName));
        String actual = userName.getText();
        String expected = "ROMAN IOVLEV";
        softAssertion.assertEquals(actual, expected,
                "Incorrect username");
    }

    public void assertAll() {
        softAssertion.assertAll();
    }
}