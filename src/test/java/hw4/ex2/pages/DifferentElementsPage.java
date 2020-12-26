package hw4.ex2.pages;

import hw4.baseclass.GetProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import static hw4.baseclass.GetProperties.NameOfProperty.EXERCISE_DATA;

public class DifferentElementsPage extends AbstractPage {
    @FindBy(xpath = "//li[3]/a[1]")
    protected WebElement serviceHeaderElement;
    @FindBy(css = ".dropdown-menu > li:nth-child(8) > a")
    protected WebElement differentElements;

    @FindBy(xpath = "//input[@type='checkbox']")
    protected WebElement water;
    @FindBy(xpath = "//label[3]/input")
    protected WebElement wind;

    @FindBy(xpath = "//div[3]/label[4]/input")
    protected WebElement selen;

    @FindBy(xpath = "//select")
    protected WebElement dropdown;

    @FindBy(xpath = "//li[contains(text(),'Water: condition changed to true')]")
    private WebElement assertCheckBoxWater;
    @FindBy(xpath = "//li[contains(text(),'Wind: condition changed to true')]")
    private WebElement assertCheckBoxWind;
    @FindBy(xpath = "//li[contains(text(),'Selen')]")
    private WebElement assertRadioBtn;
    @FindBy(xpath = "//li[contains(text(),'Color')]")
    private WebElement assertDropdown;

    private GetProperties getExerciseDataProperties = new GetProperties(EXERCISE_DATA);

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void openPage() {
        //click Service header menu
        serviceHeaderElement.click();

        //click Different Elements
        differentElements.click();
    }

    //STEP #6: Select checkboxes
    //DATA: Water, Wind
    //EXPECTED RESULT: Elements are checked
    public void selectCheckboxes() {
        //select checkbox with parameter Water
        water.click();

        //select checkbox with parameter Wind
        wind.click();
    }

    //STEP #7: Select radio
    //DATA: Selen
    //EXPECTED RESULT: Element is checked
    public void selectRadio() {
        selen.click();
    }

    //STEP #8: Select in dropdown
    //DATA: Yellow
    //EXPECTED RESULT: Element is selected
    public void selectInDropdown() {
        dropdown.click();
        Select color = new Select(dropdown);
        String selectColor = getExerciseDataProperties
                .getResource("selectInDropdown");
        color.selectByVisibleText(selectColor);
    }

    public WebElement getAssertCheckBoxWater() {
        return assertCheckBoxWater;
    }

    public WebElement getAssertCheckBoxWind() {
        return assertCheckBoxWind;
    }

    public WebElement getAssertRadioBtn() {
        return assertRadioBtn;
    }

    public WebElement getAssertDropdown() {
        return assertDropdown;
    }
}