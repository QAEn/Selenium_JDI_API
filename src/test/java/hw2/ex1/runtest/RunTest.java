package hw2.ex1.runtest;

import hw2.baseclass.DriverManager;
import hw2.ex1.pages.HomePage;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RunTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver =  new DriverManager().setupDriver();
    }

    @Test(
            description = "First exercise test, Jira binding cab be here"
    )
    public void exercise_1_Test() {
        homePage = new HomePage(driver);

        //STEP #1: Open test site by URL
        homePage.openPage();

        //STEP #2: Assert Browser title
        homePage.checkTitle();

        //STEP #3: Perform login
        homePage.login();

        //STEP #4: Assert Username is logged
        homePage.assertUserName();

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
        homePage.frameButtonExists();

        //STEP #10: Switch to original window back
        homePage.switchHomePage();
        homePage.checkTitle();

        //STEP #11: Assert that there are 5 items in the Left Section
        //          are displayed and they have proper text
        homePage.assertLeftSectionItems();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        //STEP #12: Close Browser
        driver.quit();
        driver = null;
    }
}