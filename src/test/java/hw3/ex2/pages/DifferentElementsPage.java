package hw3.ex2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class DifferentElementsPage extends AbstractPage {

    public DifferentElementsPage(WebDriver driver, SoftAssert softAssertion) {
        super(driver, softAssertion);
    }

    @Override
    public void openPage() {
        //click Service header menu
        String serviceHeaderElementProperty = getProperties.getResource("serviceHeaderElement");
        WebElement serviceHeaderElement = driver.findElement(By.xpath(serviceHeaderElementProperty));
        serviceHeaderElement.click();

        //click Different Elements
        String differentElementsProperty = getProperties.getResource("differentElements");
        WebElement differentElements = driver.findElement(By.cssSelector(differentElementsProperty));
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
        String waterProperty = getProperties.getResource("water");
        WebElement water = driver.findElement(By.xpath(waterProperty));
        water.click();

        //select checkbox with parameter Wind
        String windProperty = getProperties.getResource("wind");
        WebElement wind = driver.findElement(By.xpath(windProperty));
        wind.click();
    }

    //STEP #7: Select radio
    //DATA: Selen
    //EXPECTED RESULT: Element is checked
    public void selectRadio() {
        String selenProperty = getProperties.getResource("selen");
        WebElement selen = driver.findElement(By.xpath(selenProperty));
        selen.click();
    }

    //STEP #8: Select in dropdown
    //DATA: Yellow
    //EXPECTED RESULT: Element is selected
    public void selectInDropdown() {
        String dropdownProperty = getProperties.getResource("dropdown");
        WebElement dropdown = driver.findElement(By.xpath(dropdownProperty));
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
        String checkBoxWaterProperty = getProperties.getResource("assertCheckBoxWater");
        WebElement assertCheckBoxWater = driver.findElement(By.xpath(checkBoxWaterProperty));
        String actualWater = assertCheckBoxWater.getText();
        softAssertion.assertTrue(actualWater.contains("Water") && actualWater.endsWith("true"),
                "Log row and (or) value isn't corresponded to the status of Water's checkbox");

        //for Wind
        String checkBoxWindProperty = getProperties.getResource("assertCheckBoxWind");
        WebElement assertCheckBoxWind = driver.findElement(By.xpath(checkBoxWindProperty));
        String actualWind = assertCheckBoxWind.getText();
        softAssertion.assertTrue(actualWind.contains("Wind") && actualWind.endsWith("true"),
                "Log row and (or) value isn't corresponded to the status of Wind's checkbox");

        //for radio button there is a log row and value
        //is corresponded to the status of radio button
        String assertRadioBtnProperty = getProperties.getResource("assertRadioBtn");
        WebElement assertRadioBtn = driver.findElement(By.xpath(assertRadioBtnProperty));
        String actualRadioBtn = assertRadioBtn.getText();
        softAssertion.assertTrue(actualRadioBtn.contains("metal") && actualRadioBtn.endsWith("Selen"),
                "Log row and (or) value isn't corresponded to the status of Selen's radio button");

        //for dropdown there is a log row and value is corresponded to the selected value
        String assertDropdownProperty = getProperties.getResource("assertDropdown");
        WebElement assertDropdown = driver.findElement(By.xpath(assertDropdownProperty));
        String actualDropdown = assertDropdown.getText();
        softAssertion.assertTrue(actualDropdown.contains("Colors") && actualDropdown.endsWith("Yellow"),
                "Log row and (or) value isn't corresponded to the status of selected value");
    }
}