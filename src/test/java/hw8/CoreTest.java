package hw8;

import org.testng.annotations.*;

import hw8.core.yandexspellerservice.YandexSpellerService;

public abstract class CoreTest {

    protected YandexSpellerService yandexSpellerService;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        yandexSpellerService = new YandexSpellerService();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        yandexSpellerService = null;
    }
}