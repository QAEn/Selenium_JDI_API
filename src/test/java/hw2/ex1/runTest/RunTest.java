package hw2.ex1.runTest;

import hw2.ex1.pages.HomePage;
import hw2.ex1.webDriver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RunTest {

    //For the current exercise please use SoftAsserts!!! TODO

    private WebDriver driver;
    private DriverManager driverManager;
    private HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driverManager = new DriverManager();
        driver =  driverManager.setupDriver();
    }

    @Test(
            description = "First exercise test, Jira binding cab be here"
    )
    public void exercise_1_Test() {
        homePage = new HomePage(driver);

        homePage.openPage();                //STEP #1: Open test site by URL
        homePage.checkTitle();              //STEP #2: Assert Browser title
        homePage.login();                   //STEP #3: Perform login
        homePage.assertUserName();          //STEP #4: Assert Username is logged
        homePage.assertHeaderItems();       //STEP #5: Assert that there are 4 items on the header section are displayed and they have proper texts
        //homePage.assertImages();            //STEP #6: Assert that there are 4 images on the Index Page and they are displayed
        //homePage.assertText();              //STEP #7: Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.iframeWithButtonExists();  //STEP #8: Assert that there is the iframe with “Frame Button” exist
        homePage.frameButtonExists();       //STEP #9: Switch to the iframe and check that there is “Frame Button” in the iframe
        homePage.switchHomePage();          //STEP #10: Switch to original window back
        homePage.assertLeftSectionItems();  //STEP #11: Assert that there are 5 items in the Left Section are displayed and they have proper text
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit(); //STEP #12: Close Browser
        driver = null;
        driverManager = null;
    }
}