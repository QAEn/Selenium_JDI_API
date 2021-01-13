package hw5.services.page.component;

import hw5.services.page.AbstractPage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractPage {

    @FindBy(className = "dropdown-toggle")
    private WebElement serviceBtn;

    @FindBy(xpath = "//a[text()='Different elements']")
    private WebElement difElem;

    @FindBy(xpath = "//a[text()='User Table ']")
    private WebElement userTable;

    public Header(WebDriver driver, String dropdown) {
        super(driver);
        serviceBtn.click();
        switch (dropdown) {
            case "Different Elements":
                difElem.click();
                break;
            case "User Table":
                userTable.click();
                break;
            default:
                System.err.println(
                        "\nATTENTION: Your text input in Gherkin steps (PAGE NAME)"
                        + " doesn't match to proper condition."
                );
                break;
        }
    }
}