package hw5.steps;

import io.cucumber.java.en.Given;

public class GivenGherkin extends AbstractGherkin {

    @Given("I open JDI GitHub site")
    public void openSite() {
        homePage.openPage();
    }
}
