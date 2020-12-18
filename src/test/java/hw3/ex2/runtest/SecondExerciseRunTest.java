package hw3.ex2.runtest;

import hw3.baseclass.CoreTest;
import hw3.ex2.pages.DifferentElementsPage;
import org.testng.annotations.Test;

public class SecondExerciseRunTest extends CoreTest {

    private DifferentElementsPage differentElementsPage;

    @Test(
            description = "Second exercise test, Jira binding cab be here"
    )
    public void exercise_2_Test() {
        differentElementsPage = new DifferentElementsPage(driver, softAssertion);

        //STEP #1: Open test site by URL
        commonSteps.openPage();

        //STEP #2: Assert Browser title
        commonSteps.checkTitle();

        //STEP #3: Perform login
        commonSteps.login();

        //STEP #4: Assert Username is logged
        commonSteps.assertUserName();

        //STEP #5: Open through the header menu Service -> Different Elements Page
        differentElementsPage.openPage();
        differentElementsPage.checkTitle();

        //STEP #6: Select checkboxes
        differentElementsPage.selectCheckboxes();

        //STEP #7: Select radio
        differentElementsPage.selectRadio();

        //STEP #8: Select in dropdown
        differentElementsPage.selectInDropdown();

        //STEP #9: Assert that each element corresponds to itself with positive status
        differentElementsPage.assertActions();

        commonSteps.assertAll();
    }
}