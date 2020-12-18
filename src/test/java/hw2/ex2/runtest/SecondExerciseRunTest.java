package hw2.ex2.runtest;

import hw2.baseclass.CoreTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SecondExerciseRunTest extends CoreTest {

    @Test(
            description = "Second exercise test, Jira binding cab be here"
    )
    public void exercise_2_Test() {

        commonSteps.baseMethod();

        //STEP #5: Open through the header menu Service -> Different Elements Page
        //click Service header menu
        WebElement serviceHeaderElement = driver.findElement(By.xpath("//li[3]/a[1]"));
        serviceHeaderElement.click();

        //click Different Elements
        WebElement differentElements = driver.findElement(
                By.cssSelector("a[href*='different-elements.html']"));
        differentElements.click();
        wait.until(ExpectedConditions.titleContains("Different Elements"));

        softAssertion.assertEquals(driver.getTitle(), "Different Elements",
                "Incorrect Different Elements page title");

        //STEP #6: Select checkboxes
        //select checkbox with parameter Water
        WebElement water = driver.findElement(By.xpath("//input[@type='checkbox']"));
        water.click();

        //select checkbox with parameter Wind
        WebElement wind = driver.findElement(By.xpath("//label[3]/input"));
        wind.click();

        //STEP #7: Select radio
        WebElement selen = driver.findElement(By.xpath("//div[3]/label[4]/input"));
        selen.click();

        //STEP #8: Select in dropdown
        WebElement dropdown = driver.findElement(By.xpath("//select"));
        dropdown.click();
        Select color = new Select(dropdown);
        color.selectByVisibleText("Yellow");

        //STEP #9: Assert that each element corresponds to itself with positive status
        //for each checkbox there is an individual log row and value
        // is corresponded to the status of checkbox

        //Is this code do soft assert? <---- !!!NOPE!!! note for future
        /*List<WebElement> elements = driver
                .findElements(By.cssSelector("div[name=log-sidebar] div.info-panel-body-log"));
        List<String> texts = elements
                .stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(texts.toString(), containsString("Water: condition changed to true"));
        assertThat(texts.toString(), containsString("kjfkjdfon changed to true"));
        assertThat(texts.toString(), containsString("Selen"));
        assertThat(texts.toString(), containsString("Yellow"));*/

        //for Water
        WebElement assertCheckBoxWater = driver.findElement(
                By.xpath("//li[contains(text(),'Water: condition changed to true')]"));
        String actualWater = assertCheckBoxWater.getText();
        softAssertion.assertTrue(actualWater.contains("Water") && actualWater.endsWith("true"),
                "Log row and (or) value isn't corresponded to the status of Water's checkbox");

        //for Wind
        WebElement assertCheckBoxWind = driver.findElement(
                By.xpath("//li[contains(text(),'Wind: condition changed to true')]"));
        String actualWind = assertCheckBoxWind.getText();
        softAssertion.assertTrue(actualWind.contains("Wind") && actualWind.endsWith("true"),
                "Log row and (or) value isn't corresponded to the status of Wind's checkbox");

        //for radio button there is a log row and value
        //is corresponded to the status of radio button
        WebElement assertRadioBtn = driver.findElement(
                By.xpath("//li[contains(text(),'Selen')]"));
        String actualRadioBtn = assertRadioBtn.getText();
        softAssertion.assertTrue(actualRadioBtn.contains("metal")
                        && actualRadioBtn.endsWith("Selen"),
                "Log row and (or) value isn't corresponded to the status of Selen's radio button");

        //for dropdown there is a log row and value is corresponded to the selected value
        WebElement assertDropdown = driver.findElement(
                By.xpath("//li[contains(text(),'Color')]"));
        String actualDropdown = assertDropdown.getText();
        softAssertion.assertTrue(actualDropdown.contains("Colors")
                        && actualDropdown.endsWith("Yellow"),
                "Log row and (or) value isn't corresponded to the status of selected value");

        softAssertion.assertAll();
    }
}