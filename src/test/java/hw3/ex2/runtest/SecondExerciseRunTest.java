package hw3.ex2.runtest;

import hw3.baseclass.CoreTest;
import org.testng.annotations.Test;

public class SecondExerciseRunTest extends CoreTest {

    @Test(
            description = "Second exercise test, Jira binding cab be here"
    )
    public void exercise_2_Test() {
        //STEP #1: Open test site by URL
        commonActionStep.openTestSite();

        //STEP #2: Assert Browser title
        commonAssertSteps.assertBrowserTitle();

        //STEP #3: Perform login
        commonActionStep.performLogin();

        //STEP #4: Assert Username is logged
        commonAssertSteps.assertUserName();

        //STEP #5: Open through the header menu Service -> Different Elements Page
        secondExerciseActionStep.openPage();
        secondExerciseAssertionStep.assertTitle();

        //STEP #6: Select checkboxes
        secondExerciseActionStep.selectCheckboxes();

        //STEP #7: Select radio
        secondExerciseActionStep.selectRadio();

        //STEP #8: Select in dropdown
        secondExerciseActionStep.selectInDropdown();

        //STEP #9: Assert that each element corresponds to itself with positive status
        secondExerciseAssertionStep.assertActions();

        commonAssertSteps.assertAll();
    }
}