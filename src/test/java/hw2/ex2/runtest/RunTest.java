package hw2.ex2.runtest;

import hw2.baseclass.DriverManager;
import hw2.ex2.pages.DifferentElementsPage;
import hw2.ex2.pages.HomePage;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class RunTest {

    private WebDriver driver;
    private HomePage homePage;
    private DifferentElementsPage differentElementsPage;

    //    private String driverPath = getConfigProperty("driverPath");
    //    private String typeOfWebDriver = getConfigProperty("typeOfWebDriver");

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver =  new DriverManager().setupDriver();
    }

    @Test(
            description = "Second exercise test, Jira binding cab be here"
    )
    public void exercise_2_Test() {
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);

        //STEP #1: Open test site by URL
        homePage.openPage();

        //STEP #2: Assert Browser title
        homePage.checkTitle();

        //STEP #3: Perform login
        homePage.login();

        //STEP #4: Assert User name in the left-top side of screen that user is loggined
        homePage.assertUserName();

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
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        //STEP #10: Close Browser
        driver.quit();
        driver = null;
    }
}