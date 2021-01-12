package hw4.ex2.runtest;

import hw4.baseclass.CoreTest;
import hw4.baseclass.entity.User;
import hw4.baseclass.dataprovider.AssertDataProvider;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Feature("Selenium")
@Story("Homework #4")
public class SecondExerciseRunTest extends CoreTest {

    protected AssertDataProvider assertDataProvider;

    @Test(
            description = "Second exercise test, Jira binding cab be here"
    )
    public void exercise_2_Test() {
        assertDataProvider = new AssertDataProvider();

        //STEP #1: Open test site by URL
        homePage.openPage();

        //STEP #2: Assert Browser title
        commonAssertSteps.assertBrowserTitle(
                driver.getTitle(),
                assertDataProvider.getExpectedTitleName()
        );

        //STEP #3: Perform login
        homePage.login(
                assertDataProvider.getLoginUserName(),
                assertDataProvider.getPassword());

        //STEP #4: Assert Username is logged
        commonAssertSteps.assertUserName(
                homePage.getUserName(),
                User.getName().toUpperCase()
        );

        //STEP #5: Open through the header menu Service -> Different Elements Page
        secondExerciseActionStep.openPage();
        secondExerciseAssertionStep.assertTitle(
                driver.getTitle(),
                assertDataProvider.getAssertTitle()
        );

        //STEP #6: Select checkboxes
        secondExerciseActionStep.selectCheckboxes();

        //STEP #7: Select radio
        secondExerciseActionStep.selectRadio();

        //STEP #8: Select in dropdown
        secondExerciseActionStep.selectInDropdown();

        //STEP #9: Assert that each element corresponds to itself with positive status
        secondExerciseAssertionStep.assertActions(
                differentElementsPage.getAssertCheckBoxWater().getText(),
                differentElementsPage.getAssertCheckBoxWind().getText(),
                differentElementsPage.getAssertRadioBtn().getText(),
                differentElementsPage.getAssertDropdown().getText()
        );

        commonAssertSteps.checkAll();
    }
}