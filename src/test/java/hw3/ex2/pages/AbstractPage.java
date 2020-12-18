package hw3.ex2.pages;

        import hw3.baseclass.GetProperties;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.asserts.SoftAssert;
        import static hw3.baseclass.GetProperties.NumberOfExercise.SECOND_EXERCISE;

public abstract class AbstractPage {
    public WebDriver driver;
    public WebDriverWait wait;
    public SoftAssert softAssertion;
    public GetProperties getProperties = new GetProperties(SECOND_EXERCISE);

    public abstract void openPage();

    public abstract void checkTitle();

    public AbstractPage(WebDriver driver, SoftAssert softAssertion) {
        this.driver = driver;
        this.softAssertion = softAssertion;
    }
}