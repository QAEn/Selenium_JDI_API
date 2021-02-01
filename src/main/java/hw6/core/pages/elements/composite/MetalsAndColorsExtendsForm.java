package hw6.core.pages.elements.composite;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.*;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.jdi.light.ui.html.elements.common.*;

import hw6.core.pages.elements.composite.pageentity.MetalsAndColorsEntity;

public class MetalsAndColorsExtendsForm extends Form<MetalsAndColorsEntity> {

    @UI("[name=custom_radio_odd]")
    public RadioButtons summaryTop;
    @UI("[name=custom_radio_even]")
    public RadioButtons summaryBottom;

    @UI(".summ-res")
    private UIElement summary;

    @FindBy(css = "section[id=elements-checklist] input[type=checkbox]")
    public Checklist elementChecklist;

    @JDropdown(
            root = "div[ui=dropdown]",
            value = ".filter-option",
            list = "li",
            expand = ".caret"
    )
    public Dropdown colors;

    @JDropdown(
            root = "div[ui=combobox]",
            value = "input",
            list = "li",
            expand = ".caret"
    )
    public Dropdown metals;

    @FindBy(id = "salad-dropdown")
    private Button vegetablesBtn;

    @FindBy(css = "#salad-dropdown  input")
    private Checklist vegetables;

    @UI("['Submit']")
    public Button submit;

    @Override
    public void fill(MetalsAndColorsEntity data) {
        summaryTop.select(data.getSummary().get(0));
        summaryBottom.select(data.getSummary().get(1));

        data.getElements().forEach(elementChecklist::select);

        metals.select(data.getMetals());

        colors.select(data.getColor());

        vegetablesBtn.click();
        vegetables.select("Vegetables");
        data.getVegetables().forEach(vegetables::select);

        pressSubmitBtn();
    }

    public void pressSubmitBtn() {
        submit.click();
    }

}