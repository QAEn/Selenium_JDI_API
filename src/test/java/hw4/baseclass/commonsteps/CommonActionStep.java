package hw4.baseclass.commonsteps;

import hw4.baseclass.BaseClass;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActionStep {

    BaseClass baseClass;

    public CommonActionStep(WebDriver driver, WebDriverWait wait) {
        baseClass = new BaseClass(driver, wait);
    }

    //STEP #1: Open test site by URL
    //DATA: https://jdi-testing.github.io/jdi-light/index.html
    //EXPECTED RESULT: Test site is opened
    @Step("STEP #1: Open test site by URL")
    public void openTestSite() {
        baseClass.openPage();
    }

    //STEP #3: Perform login
    //DATA: username: Roman, pass: Jdi1234
    //EXPECTED RESULT: User is logged
    @Step("STEP #3: Perform login")
    public void performLogin() {
        baseClass.login();
    }
}