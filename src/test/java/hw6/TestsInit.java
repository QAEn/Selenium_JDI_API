package hw6;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;

import org.testng.annotations.*;

public interface TestsInit {

    @BeforeSuite
    default void setupTest() {
        PageFactory.initSite(Site.class);
    }

    @AfterSuite
    default void teardownTest() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}