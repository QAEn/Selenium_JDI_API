package hw3.ex2.steps;

import hw3.ex2.pages.DifferentElementsPage;
import org.openqa.selenium.WebDriver;

public class SecondExerciseActionStep {

    DifferentElementsPage differentElementsPage;

    public SecondExerciseActionStep(WebDriver driver) {
        differentElementsPage = new DifferentElementsPage(driver);
    }

    //STEP #5: Open through the header menu Service -> Different Elements Page
    //DATA: -
    //EXPECTED RESULT: Page is opened
    public void openPage() {
        differentElementsPage.openPage();
    }

    //STEP #6: Select checkboxes
    //DATA: Water, Wind
    //EXPECTED RESULT: Elements are checked
    public void selectCheckboxes() {
        differentElementsPage.selectCheckboxes();
    }

    //STEP #7: Select radio
    //DATA: Selen
    //EXPECTED RESULT: Element is checked
    public void selectRadio() {
        differentElementsPage.selectRadio();
    }

    //STEP #8: Select in dropdown
    //DATA: Yellow
    //EXPECTED RESULT: Element is selected
    public void selectInDropdown() {
        differentElementsPage.selectInDropdown();
    }
}