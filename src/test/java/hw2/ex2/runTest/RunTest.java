package hw2.ex2.runTest;

import hw2.ex1.pages.HomePage;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class RunTest {

    private WebDriver driver;
    private String driverPath = getConfigProperty("driverPath");
    private String typeOfWebDriver = getConfigProperty("typeOfWebDriver");
    private HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty(typeOfWebDriver, driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Какой из вариантов wait необходимо использовать в этой точке?
        //Page load:
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //Script:
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    @Test(
            description = "Second exercise test, Jira binding cab be here"
    )
    public void exercise_1_Test() throws InterruptedException {
        homePage = new HomePage(driver);

        homePage.openPage();            //STEP #1: Open test site by URL
        homePage.checkTitle();          //STEP #2: Assert Browser title
        homePage.login();               //STEP #3: Perform login
        homePage.assertUserName();      //STEP #4: Assert User name in the left-top side of screen that user is loggined
        //STEP #5: Open through the header menu Service -> Different Elements Page
        //STEP #6: Select checkboxes
        //STEP #7: Select radio
        //STEP #8: Select in dropdown

        /*
        STEP #9: Assert that:
        •	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        •	for radio button there is a log row and value is corresponded to the status of radio button
        •	for dropdown there is a log row and value is corresponded to the selected value.
        */

        Thread.sleep(1000);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit(); //STEP #10: Close Browser
        driver = null;
    }

    private String getConfigProperty(String nameOfProperty) {
        final Properties property = new Properties();
        try (final FileInputStream fis = new FileInputStream("src/test/resources/hw2/properties/config.properties"))
        {
            property.load(fis);
        } catch (FileNotFoundException e) {
            System.out.println("File with resources of web driver was not founded (exercise 2)");
        } catch (IOException e) {
            System.out.println("IOException for web driver (exercise 2)");
        }
        return property.getProperty(nameOfProperty);
    }
}
