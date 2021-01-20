package hw5.steps;

import hw5.services.entity.User;
import hw5.services.page.component.*;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import java.util.List;

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

    @Then("{string} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void assertDropdowns(String amountDropdowns) {
        softAssert.assertEquals(
                userTablePage.getSixDropdowns(), amountDropdowns,
                "\nIncorrect \'" + amountDropdowns + "\' amount of DROPDOWNS on User Table Page\n"
        );
    }

    @Then("{string} Usernames should be displayed on Users Table on User Table Page")
    public void assertUsernames(String amountUsernames) {
        softAssert.assertEquals(
                userTablePage.getSixUsernames(), amountUsernames,
                "\nIncorrect \'" + amountUsernames + "\' amount of USERNAMES on User Table Page\n"
        );
    }

    @Then("{string} Description texts under images should be displayed on Users Table on "
            + "User Table Page")
    public void assertDescription(String amountDescription) {
        softAssert.assertEquals(
                userTablePage.getSixDescription(), amountDescription,
                "\nIncorrect \'" + amountDescription
                        + "\' amount of DESCRIPTION on User Table Page\n"
        );
    }

    @Then("{string} checkboxes should be displayed on Users Table on User Table Page")
    public void assertCheckboxes(String amountCheckBoxes) {
        softAssert.assertEquals(
                userTablePage.getSixCheckboxes(), amountCheckBoxes,
                "\nIncorrect \'" + amountCheckBoxes + "\' amount of CHECKBOXES on User Table Page\n"
        );
    }

    @Then("User table should contain following values:")
    public void assertTable(DataTable dataTable) {
        List<List<String>> table = dataTable.asLists(String.class);

        for (int j = 1; j < table.size(); j++) {
            String expectedNumber = table.get(j).get(0);
            String expectedName = table.get(j).get(1);
            String expectedDes = table.get(j).get(2);
            //System.out.println("\nnumber from GherkinTable (expected) >>> "+ expectedNumber);
            //System.out.println("name from GherkinTable (expected) >>> "+ expectedName);
            //System.out.println("des from GherkinTable (expected) >>> "+ expectedDes);

            for (int i = 0; i < table.size(); i++) {
                //System.err.println("number from Page (actual) >>> "
                // + userTablePage.getNumber2().get(j-1));
                //System.err.println("name from Page (actual) >>> "
                // + userTablePage.getUser2().get(j-1));
                //System.err.println("des from Page (actual) >>> "
                // + userTablePage.getDescription().get(j-1));

                softAssert.assertEquals(userTablePage.getNumber().get(j - 1), expectedNumber,
                        "\n>>>Failed assert number<<<\n"
                                + "Actual: " + userTablePage.getNumber().get(j - 1)
                                + "\nExpected: " + expectedNumber + "\n"
                );

                softAssert.assertEquals(userTablePage.getUser().get(j - 1), expectedName,
                        "\n>>>Failed assert name<<<\n"
                                + "Actual: " + userTablePage.getUser().get(j - 1)
                                + "\nExpected: " + expectedName + "\n"
                );

                softAssert.assertEquals(userTablePage.getDescription().get(j - 1), expectedDes,
                        "\n>>>Failed assert description<<<\n"
                                + "Actual: " + userTablePage.getDescription().get(j - 1)
                                + "\nExpected: " + expectedDes + "\n"
                );
            }
        }
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void droplist(DataTable dataTable) {
        List<List<String>> table = dataTable.asLists(String.class);

        for (int j = 1; j < table.size(); j++) {
            String expectedRole = table.get(j).get(0);
            //System.out.println("\nrole from GherkinTable (expected) >>> "+ expectedRole);

            for (int i = 0; i < userTablePage.getRomanRole().size(); i++) {

                //System.err.println("role from Page (actual) >>> "
                // + userTablePage.getRomanRole().get(j-1));

                softAssert.assertEquals(userTablePage.getRomanRole().get(j - 1), expectedRole,
                        "\n>>>Failed assert role<<<\n"
                                + "Actual: " + userTablePage.getRomanRole().get(j - 1)
                                + "\nExpected: " + expectedRole + "\n"
                );

            }
        }

        softAssert.assertAll("\nFailed assertAll\n");
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
