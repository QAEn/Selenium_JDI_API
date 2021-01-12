package hw5.steps;

import hw5.services.entity.User;
import hw5.services.page.component.CheckBox;
import hw5.services.page.component.Dropdown;
import hw5.services.page.component.RadioButton;
import io.cucumber.java.en.Then;

public class ThenGherkin extends AbstractGherkin {

    //Background:

    @Then("User name should be displayed and equals to expected result")
    public void assertUsername() {
        softAssert.assertEquals(
                homePage.getUserName(),
                User.getName().toUpperCase(),
                "\nIncorrect username\n"
        );
    }

    //Scenario: Exercise 1

    @Then("{string} page should be opened")
    public void assertPageOpen(String expectedText) {
        softAssert.assertEquals(driver.getTitle(), expectedText,
                "\nIncorrect " + expectedText + " title\n"
        );
    }

    @Then("Each element should be corresponds to itself"
            + " with positive status on Different Elements Page")
    public void assertElementsOnDifferentElementsPage() {
        String actualLogRow = differentElementsPage.getAssertLogRow();

        softAssert.assertEquals(
                actualLogRow.contains(CheckBox.getFirstCheckbox()),true,
                String.format("\nLog row and (or) value isn't corresponded to"
                                + " the status of %s checkbox\n",
                        CheckBox.getFirstCheckbox())
        );
        softAssert.assertEquals(
                actualLogRow.contains(CheckBox.getSecondCheckbox()),true,
                String.format("\nLog row and (or) value isn't corresponded to"
                                + " the status of %s checkbox\n",
                        CheckBox.getSecondCheckbox())
        );
        softAssert.assertEquals(
                actualLogRow.contains(RadioButton.getName()),true,
                String.format("\nLog row and (or) value isn't corresponded to"
                                + " the status of %s radio button\n",
                        RadioButton.getName())
        );
        softAssert.assertEquals(
                actualLogRow.contains(Dropdown.getColor()),true,
                String.format("\nLog row and (or) value isn't corresponded to"
                                + " the status of selected color (%s) value\n",
                        Dropdown.getColor())
        );

        softAssert.assertAll("\nFailed assertAll\n");

        driver.quit();
        driver = null;
    }

    //Scenario: Exercise 2

    @Then("6 {string} Type Dropdowns should be displayed on Users Table on User Table Page")
    public void assertDropdowns(String dropdowns) {
        softAssert.assertTrue(
                userTablePage.getNumber(dropdowns),
                "\nIncorrect \'" + dropdowns + "\' number on User Table Page\n"
        );
    }

    @Then("6 {string}names should be displayed on Users Table on User Table Page")
    public void assertUsernames(String usernames) {
        softAssert.assertTrue(
                userTablePage.getUser(usernames),
                "\nIncorrect \'" + usernames + "\' username on User Table Page\n"
        );
    }

    @Then("6 {string} texts under images should be displayed on Users Table on User Table Page")
    public void assertDescription(String description) {
        softAssert.assertTrue(
                userTablePage.getDescription(description),
                "\nIncorrect \'" + description + "\' description on User Table Page\n"
        );
    }

    @Then("{string} checkboxes should be displayed on Users Table on User Table Page")
    public void assertCheckboxes(String amountCheckBoxes) {
        softAssert.assertEquals(
                userTablePage.assertSixCheckboxes(), amountCheckBoxes,
                "\nIncorrect \'" + amountCheckBoxes + "\' amount of checkboxes on User Table Page\n"
        );


        softAssert.assertAll("\nFailed assertAll\n");
    }

    @Then("{string} should contain values in column Type for user Roman")
    public void assertDroplist(String droplist) {
        softAssert.assertEquals(
                userTablePage.assertDroplist(), droplist,
                "\nIncorrect \'" + droplist + "\' droplist on User Table Page\n"
        );
    }

    //Scenario: Exercise 3

    @Then("1 log row has {string} text in log section")
    public void assertVipCheckbox(String vip) {
        softAssert.assertTrue(userTablePage.getAssertRow().equals(vip),
                "\nLog row value isn't corresponded to the status of selected value\n" + vip
        );

        softAssert.assertAll("\nFailed assertAll\n");
    }
}
