package hw4.ex1.runtest;

import hw4.baseclass.CoreTest;
import hw4.baseclass.dataprovider.AssertDataProvider;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Selenium")
@Story("Homework #4")
public class FirstExerciseRunTest extends CoreTest {

    @Test(
            description = "First exercise test, Jira binding cab be here",
            dataProvider = "assertTextDataSet",
            dataProviderClass = AssertDataProvider.class
    )
    public void exercise_1_Test(String expectedMicroscope, String expectedHeadphones,
                                String expectedMonitor, String expectedRocket) {
        //STEP #1: Open test site by URL
        commonActionStep.openTestSite();

        //STEP #2: Assert Browser title
        commonAssertSteps.assertBrowserTitle();

        //STEP #3: Perform login
        commonActionStep.performLogin();

        //STEP #4: Assert Username is logged
        commonAssertSteps.assertUserName();

        //STEP #5: Assert that there are 4 items on the header section
        //         are displayed and they have proper texts
        firstExerciseAssertionStep.assertHeaderItemsOnHomePage();

        //STEP #6: Assert that there are 4 images on the Index Page and they are displayed
        firstExerciseAssertionStep.assertImagesOnHomePage();

        //STEP #7: Assert that there are 4 texts on the Index Page
        //         under icons and they have proper text
        firstExerciseAssertionStep.assertTextOnHomePage(
                expectedMicroscope, expectedHeadphones, expectedMonitor, expectedRocket
        );

        //STEP #8: Assert that there is the iframe with “Frame Button” exist
        firstExerciseAssertionStep.iframeWithButtonExists();

        //STEP #9: Switch to the iframe and check that there is “Frame Button” in the iframe
        firstExerciseAssertionStep.frameButtonExists();

        //STEP #10: Switch to original window back
        firstExerciseActionStep.switchHomePage();

        //STEP #11: Assert that there are 5 items in the Left Section
        //          are displayed and they have proper text
        firstExerciseAssertionStep.assertLeftSectionItems();

        commonAssertSteps.checkAll();
    }
}