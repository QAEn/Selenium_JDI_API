package hw4.ex2.steps;

import hw4.baseclass.GetProperties;
import hw4.ex2.pages.DifferentElementsPage;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
import static hw4.baseclass.GetProperties.NameOfProperty.EXERCISE_DATA;

public class SecondExerciseAssertionStep {

    private DifferentElementsPage differentElementsPage;
    private WebDriver driver;
    private SoftAssert softAssertion;
    private GetProperties getExerciseDataProperties = new GetProperties(EXERCISE_DATA);

    public SecondExerciseAssertionStep(WebDriver driver, SoftAssert softAssertion) {
        differentElementsPage = new DifferentElementsPage(driver);
        this.softAssertion = softAssertion;
        this.driver = driver;
    }

    public void assertTitle() {
        softAssertion.assertEquals(driver.getTitle(),
                getExerciseDataProperties.getResource("assertTitle"),
                "Incorrect Different Elements page title");
    }

    //STEP #9:
    //Assert that:
    //-for each checkbox there is an individual log row and value
    //  is corresponded to the status of checkbox
    //-for radio button there is a log row and value is corresponded to the status of radio button
    //-for dropdown there is a log row and value is corresponded to the selected value.
    //DATA: -
    //EXPECTED RESULT:
    //Log rows are displayed and
    //-checkbox name and its status are corresponding to selected
    //-radio button name and it status is corresponding to selected
    //-dropdown name and selected value is corresponding to selected
    @Step("STEP #9:\n"
            + "Assert that:\n"
            + "-for each checkbox there is an individual log row and value\n"
            + "  is corresponded to the status of checkbox\n"
            + "-for radio button there is a log row and value is"
            + "  corresponded to the status of radio button\n"
            + "-for dropdown there is a log row and value is corresponded to the selected value.")
    public void assertActions() {

        //for each checkbox there is an individual log row and value
        // is corresponded to the status of checkbox

        //for Water
        String actualWater = differentElementsPage.getAssertCheckBoxWater().getText();
        softAssertion.assertTrue(actualWater.contains("Water") && actualWater.endsWith("true"),
                "Log row and (or) value isn't corresponded to the status of Water's checkbox");

        //for Wind
        String actualWind = differentElementsPage.getAssertCheckBoxWind().getText();
        softAssertion.assertTrue(actualWind.contains("Wind") && actualWind.endsWith("true"),
                "Log row and (or) value isn't corresponded to the status of Wind's checkbox");

        //for radio button there is a log row and value
        //is corresponded to the status of radio button
        String actualRadioBtn = differentElementsPage.getAssertRadioBtn().getText();
        softAssertion.assertTrue(
                actualRadioBtn.contains("metal") && actualRadioBtn.endsWith("Selen"),
                "Log row and (or) value isn't corresponded to the status of Selen's radio button"
        );

        //for dropdown there is a log row and value is corresponded to the selected value
        String actualDropdown = differentElementsPage.getAssertDropdown().getText();
        softAssertion.assertTrue(
                actualDropdown.contains("Colors") && actualDropdown.endsWith("Yellow"),
                "Log row and (or) value isn't corresponded to the status of selected value"
        );
    }
}