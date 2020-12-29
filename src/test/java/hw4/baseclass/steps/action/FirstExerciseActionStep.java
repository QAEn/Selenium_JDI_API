package hw4.baseclass.steps.action;

import hw4.baseclass.pages.HomePage;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstExerciseActionStep {

    private WebDriverWait wait;
    private HomePage homePage;

    public FirstExerciseActionStep(WebDriver driver, WebDriverWait wait) {
        homePage = new HomePage(driver, wait);
        this.wait = wait;
    }

    //STEP #10: Switch to original window back
    //DATA: -
    //EXPECTED RESULT: Driver has focus on the original window
    @Step("STEP #10: Switch to original window back")
    public void switchHomePage() {
        homePage.switchHomePage();
    }
}