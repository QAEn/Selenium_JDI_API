package hw4.ex1.steps;

import hw4.ex1.pages.HomePage;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

public class FirstExerciseActionStep {

    HomePage homePage;

    public FirstExerciseActionStep(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    //STEP #10: Switch to original window back
    //DATA: -
    //EXPECTED RESULT: Driver has focus on the original window
    @Step("STEP #10: Switch to original window back")
    public void switchHomePage() {
        homePage.switchHomePage();
    }
}