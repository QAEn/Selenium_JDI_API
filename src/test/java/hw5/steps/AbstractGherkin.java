package hw5.steps;

import hw5.services.page.UserTablePage;
import org.openqa.selenium.WebDriver;
import hw5.services.driver.WebDriverSingleton;

import hw5.services.page.HomePage;
import hw5.services.page.component.Header;
import hw5.services.page.DifferentElementsPage;

import hw5.services.dataprovider.TestDataProvider;
import org.testng.asserts.SoftAssert;

public abstract class AbstractGherkin {

    protected WebDriver driver;

    protected HomePage homePage;
    protected Header header;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;

    protected TestDataProvider testDataProvider;
    protected SoftAssert softAssert;


    protected AbstractGherkin() {
        driver = WebDriverSingleton.getDriver();

        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        userTablePage = new UserTablePage(driver);

        testDataProvider = new TestDataProvider();
        softAssert = new SoftAssert();
    }
}