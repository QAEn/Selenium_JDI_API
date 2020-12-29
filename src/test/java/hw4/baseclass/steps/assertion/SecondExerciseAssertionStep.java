package hw4.baseclass.steps.assertion;

import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

public class SecondExerciseAssertionStep {

    private SoftAssert softAssertion;

    public SecondExerciseAssertionStep(SoftAssert softAssertion) {
        this.softAssertion = softAssertion;
    }

    public void assertTitle(String actual, String expected) {
        softAssertion.assertEquals(actual, expected,
                "Incorrect Different Elements page title");
    }

    @Step("STEP #9:\n"
            + "Assert that:\n"
            + "-for each checkbox there is an individual log row and value\n"
            + "  is corresponded to the status of checkbox\n"
            + "-for radio button there is a log row and value is"
            + "  corresponded to the status of radio button\n"
            + "-for dropdown there is a log row and value is corresponded to the selected value.")
    public void assertActions(String water, String actualWind,
                              String actualRadioBtn, String actualDropdown
    ) {
        softAssertion.assertTrue(water.contains("Water") && water.endsWith("true"),
                "Log row and (or) value isn't corresponded to the status of Water's checkbox");

        softAssertion.assertTrue(actualWind.contains("Wind") && actualWind.endsWith("true"),
                "Log row and (or) value isn't corresponded to the status of Wind's checkbox");

        softAssertion.assertTrue(
                actualRadioBtn.contains("metal") && actualRadioBtn.endsWith("Selen"),
                "Log row and (or) value isn't corresponded to the status of Selen's radio button"
        );

        softAssertion.assertTrue(
                actualDropdown.contains("Colors") && actualDropdown.endsWith("Yellow"),
                "Log row and (or) value isn't corresponded to the status of selected value"
        );
    }
}