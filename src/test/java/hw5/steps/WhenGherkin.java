package hw5.steps;

import hw5.services.page.component.Header;
import io.cucumber.java.en.When;

public class WhenGherkin extends AbstractGherkin {

    //Background:

    @When("I login as user {string} with password {string}")
    public void login(String username, String password) {
        homePage.login(username, password);
    }

    @When("I click on {string} button in Service dropdown")
    public void openServicePage(String dropdownName) {
        header = new Header(driver, dropdownName);
    }

    //Scenario: Exercise 1

    @When("I select {string} and {string} checkboxes")
    public void selectCheckboxes(String firstCheckBox, String secondCheckbox) {
        differentElementsPage.selectCheckboxes(firstCheckBox, secondCheckbox);
    }

    @When("I select {string} radiobutton")
    public void selectRadioBtn(String radioBtn) {
        differentElementsPage.selectRadioBtn(radioBtn);
    }

    @When("I select {string} in dropdown")
    public void selectColor(String color) {
        differentElementsPage.selectColor(color);
    }

    //Scenario: Exercise 3

    @When("I select {string} checkbox for {string}")
    public void selectVipCheckbox(String vip, String name) {
        userTablePage.selectVipCheckbox(vip, name);
    }
}