package hw3.ex2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DifferentElementsPage extends AbstractPage {

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8")
    List<WebElement> elementsHeader;

    @FindBy(xpath = "//li[3]/a[1]")
    WebElement serviceHeaderElement;
    @FindBy(css = ".dropdown-menu > li:nth-child(8) > a")
    WebElement differentElements;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement water;
    @FindBy(xpath = "//label[3]/input")
    WebElement wind;

    @FindBy(xpath = "//div[3]/label[4]/input")
    WebElement selen;

    @FindBy(xpath = "//select")
    WebElement dropdown;

    @FindBy(xpath = "//li[contains(text(),'Water: condition changed to true')]")
    WebElement assertCheckBoxWater;
    @FindBy(xpath = "//li[contains(text(),'Wind: condition changed to true')]")
    WebElement assertCheckBoxWind;
    @FindBy(xpath = "//li[contains(text(),'Selen')]")
    WebElement assertRadioBtn;
    @FindBy(xpath = "//li[contains(text(),'Color')]")
    WebElement assertDropdown;

    public DifferentElementsPage(WebDriver driver, SoftAssert softAssertion) {
        super(driver, softAssertion);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void openPage() {
        //click Service header menu
        serviceHeaderElement.click();

        //click Different Elements
        differentElements.click();
    }

    @Override
    public void checkTitle() {
        softAssertion.assertEquals(driver.getTitle(), "Different Elements",
                "Incorrect Different Elements page title");
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
        color.selectByVisibleText("Yellow");
    }

    //STEP #9:
    //Assert that:
    //-for each checkbox there is an individual log row and value
    //  is corresponded to the status of checkbox
    //-for radio button there is a log row and value is corresponded to the status of radio button
    //-for dropdown there is a log row and value is corresponded to the selected value.
    //DATA: -
    //EXPECTED RESULT:
    //Log rows are displayed and
    //-checkbox name and its status are corresponding to selected
    //-radio button name and it status is corresponding to selected
    //-dropdown name and selected value is corresponding to selected
    public void assertActions() {
        //for each checkbox there is an individual log row and value
        // is corresponded to the status of checkbox

        //for Water
        String actualWater = assertCheckBoxWater.getText();
        softAssertion.assertTrue(actualWater.contains("Water") && actualWater.endsWith("true"),
                "Log row and (or) value isn't corresponded to the status of Water's checkbox");

        //for Wind
        String actualWind = assertCheckBoxWind.getText();
        softAssertion.assertTrue(actualWind.contains("Wind") && actualWind.endsWith("true"),
                "Log row and (or) value isn't corresponded to the status of Wind's checkbox");

        //for radio button there is a log row and value
        //is corresponded to the status of radio button
        String actualRadioBtn = assertRadioBtn.getText();
        softAssertion.assertTrue(
                actualRadioBtn.contains("metal") && actualRadioBtn.endsWith("Selen"),
                "Log row and (or) value isn't corresponded to the status of Selen's radio button"
        );

        //for dropdown there is a log row and value is corresponded to the selected value
        String actualDropdown = assertDropdown.getText();
        softAssertion.assertTrue(
                actualDropdown.contains("Colors") && actualDropdown.endsWith("Yellow"),
                "Log row and (or) value isn't corresponded to the status of selected value"
        );
    }
}