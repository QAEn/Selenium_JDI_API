package hw4.baseclass.steps.assertion;

import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

public class CommonAssertSteps {

    private SoftAssert softAssertion;


    public CommonAssertSteps(SoftAssert softAssertion) {
        this.softAssertion = softAssertion;
    }

    @Step("STEP #2: Assert Browser title")
    public void assertBrowserTitle(String actual, String expected) {
        softAssertion.assertEquals(actual, expected,
                "Incorrect page title");
    }

    @Step("STEP #4: Assert Username is logged")
    public void assertUserName(String actual, String expected) {
        softAssertion.assertEquals(actual, expected,
                "Incorrect username");
    }

    public void checkAll() {
        softAssertion.assertAll();
    }
}