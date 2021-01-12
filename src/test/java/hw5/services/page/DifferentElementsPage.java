package hw5.services.page;

import hw5.services.page.component.CheckBox;
import hw5.services.page.component.Dropdown;
import hw5.services.page.component.RadioButton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DifferentElementsPage extends AbstractPage {

    @FindBy(css = ".dropdown-menu > li:nth-child(8) > a")
    protected WebElement differentElements;

    @FindBy(css = "option")
    protected List<WebElement> colors;

    @FindBy(xpath = "//select")
    protected WebElement dropdown;

    @FindBy(className = "info-panel-section")
    private List<WebElement> assertLogRow;

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkBoxList;

    @FindBy(className = "label-radio")
    private List<WebElement> radioBtnList;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        differentElements.click();
    }

    public void selectCheckboxes(String firstCheckBox, String secondCheckBox) {
        CheckBox.getInstance(firstCheckBox, secondCheckBox);

        for (WebElement firstCheckbox: checkBoxList) {
            if (firstCheckbox.getText().equals(CheckBox.getFirstCheckbox())) {
                firstCheckbox.click();
            }
        }
        Optional<WebElement> radio = checkBoxList
                .stream()
                .filter(t -> t.getText().equals(CheckBox.getSecondCheckbox()))
                .findFirst();
        radio.ifPresent(WebElement::click);
    }

    public void selectRadioBtn(String radioBtn) {
        RadioButton.getInstance(radioBtn);
        for (WebElement radBtn: radioBtnList) {
            if (radBtn.getText().equals(RadioButton.getName())) {
                radBtn.click();
            }
        }
    }

    public void selectColor(String color) {
        Dropdown.getInstance(color);
        dropdown.click();
        for (WebElement colorName: colors) {
            if (colorName.getText().equals(color)) {
                colorName.click();
            }
        }
    }

    public String getAssertLogRow() {
        return assertLogRow.stream().map(WebElement::getText).collect(Collectors.toList()).get(0);
    }
}