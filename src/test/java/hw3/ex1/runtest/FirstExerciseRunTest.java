package hw3.ex1.runtest;

import hw3.baseclass.CoreTest;
import hw3.ex1.pages.FramePage;
import hw3.ex1.pages.HomePage;
import org.testng.annotations.Test;

public class FirstExerciseRunTest extends CoreTest {

    private HomePage homePage;
    private FramePage framePage;

    @Test(
            description = "First exercise test, Jira binding cab be here"
    )
    public void exercise_1_Test() {
        homePage = new HomePage(driver, softAssertion);
        framePage = new FramePage(driver, softAssertion);

        //STEP #1: Open test site by URL
        commonSteps.openPage();

        //STEP #2: Assert Browser title
        commonSteps.checkTitle();

        //STEP #3: Perform login
        commonSteps.login();

        //STEP #4: Assert Username is logged
        commonSteps.assertUserName();

        //STEP #5: Assert that there are 4 items on the header section
        //         are displayed and they have proper texts
        homePage.assertHeaderItems();

        //STEP #6: Assert that there are 4 images on the Index Page and they are displayed
        homePage.assertImages();

        //STEP #7: Assert that there are 4 texts on the Index Page
        //         under icons and they have proper text
        homePage.assertText();

        //STEP #8: Assert that there is the iframe with “Frame Button” exist
        homePage.iframeWithButtonExists();

        //STEP #9: Switch to the iframe and check that there is “Frame Button” in the iframe
        framePage.frameButtonExists();

        //STEP #10: Switch to original window back
        homePage.switchHomePage();

        //STEP #11: Assert that there are 5 items in the Left Section
        //          are displayed and they have proper text
        homePage.assertLeftSectionItems();

        commonSteps.assertAll();
    }
}