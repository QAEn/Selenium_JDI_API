package hw2.ex2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DifferentElementsPage extends AbstractPage {

    public DifferentElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    //STEP #5: Open through the header menu Service -> Different Elements Page
    //DATA: -
    //EXPECTED RESULT: Page is opened
    @Override
    public void openPage() {
        //click Service header menu
        String serviceHeaderElement = getProperties.getResource("serviceHeaderElement");
        waitForElementLocatedBy(driver, By.xpath(serviceHeaderElement)).click();

        //click Different Elements
        String differentElements = getProperties.getResource("differentElements");
        waitForElementLocatedBy(driver, By.xpath(differentElements)).click();
    }

    @Override
    public void checkTitle() {
        Assert.assertEquals(driver.getTitle(), "Different Elements");
    }

    //STEP #6: Select checkboxes
    //DATA: Water, Wind
    //EXPECTED RESULT: Elements are checked
    public void selectCheckboxes() {
        //select checkbox with parameter Water
        String water = getProperties.getResource("water");
        waitForElementLocatedBy(driver, By.xpath(water)).click();

        //select checkbox with parameter Wind
        String wind = getProperties.getResource("wind");
        waitForElementLocatedBy(driver, By.xpath(wind)).click();
    }

    //STEP #7: Select radio
    //DATA: Selen
    //EXPECTED RESULT: Element is checked
    public void selectRadio() {
        String selen = getProperties.getResource("selen");
        waitForElementLocatedBy(driver, By.xpath(selen));
        driver.findElement(By.xpath(selen)).click();
    }

    //STEP #8: Select in dropdown
    //DATA: Yellow
    //EXPECTED RESULT: Element is selected
    public void selectInDropdown() {
        String dropdown = getProperties.getResource("dropdown");
        Select color = new Select(driver.findElement(By.xpath(dropdown)));
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
        String assertCheckBoxWater = getProperties.getResource("assertCheckBoxWater");
        String actualWater = waitForElementLocatedBy(driver, By.xpath(assertCheckBoxWater))
                                                                                .getText();
        Assert.assertTrue(actualWater.contains("Water") && actualWater.endsWith("true"));

        //for Wind
        String assertCheckBoxWind = getProperties.getResource("assertCheckBoxWind");
        String actualWind = waitForElementLocatedBy(driver, By.xpath(assertCheckBoxWind)).getText();
        Assert.assertTrue(actualWind.contains("Wind") && actualWind.endsWith("true"));

        //for radio button there is a log row and value
        //is corresponded to the status of radio button
        String assertRadioBtn = getProperties.getResource("assertRadioBtn");
        String actual = waitForElementLocatedBy(driver, By.xpath(assertRadioBtn)).getText();

        //В требованиях ожидается статус, а фактически явного слова true или какого-либо
        //другого признака, указывающего на состояние в строке ответа нет
        Assert.assertTrue(actual.contains("metal") && actual.endsWith("Selen"));

        //for dropdown there is a log row and value is corresponded to the selected value
        String assertDropdown = getProperties.getResource("assertDropdown");
        String actualDropdown = waitForElementLocatedBy(driver, By.xpath(assertDropdown)).getText();
        Assert.assertTrue(actualDropdown.contains("Colors") && actualDropdown.endsWith("Yellow"));
    }
}