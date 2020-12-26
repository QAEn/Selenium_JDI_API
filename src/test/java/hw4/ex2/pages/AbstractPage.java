package hw4.ex2.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    public WebDriver driver;

    public abstract void openPage();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}