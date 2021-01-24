package hw6.core.pages;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.*;
import com.epam.jdi.light.ui.html.elements.common.*;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import hw6.core.entities.datafromjsonfile.*;

import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.stream.Collectors;

public class MetalsAndColorsPage extends WebPage {

    @UI("[name=custom_radio_odd]")
    public RadioButtons summaryTop;

    @UI("[name=custom_radio_even]")
    public RadioButtons summaryBottom;

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

    @JDropdown(
            root = "div[ui=droplist]",
            value = "button",
            list = "li",
            expand = ".caret"
    )
    public Dropdown vegetables;

    @XPath("//input[@id='g7']")
    public Checkbox vegetableCheckBox;

    @UI("['Submit']")
    public Button submit;

    @FindBy(xpath = "//section[2]/div[2]/div")
    private List<WebElement> assertRow;

    public void selectData1(Data1 data1) {
        summaryTop.select(String.valueOf(data1.getSummary().getAsJsonArray().get(0)));
        summaryBottom.select(String.valueOf(data1.getSummary().getAsJsonArray().get(1)));

        JsonArray arrayList = data1.getElements().getAsJsonArray();
        if (arrayList.size() == 2) {
            elementChecklist.select(String.valueOf(arrayList.get(0)));
            elementChecklist.select(String.valueOf(arrayList.get(1)));
        } else {
            elementChecklist.select(String.valueOf(arrayList.get(0)));
            elementChecklist.select(String.valueOf(arrayList.get(1)));
            elementChecklist.select(String.valueOf(arrayList.get(2)));
            elementChecklist.select(String.valueOf(arrayList.get(3)));
        }

        colors.select(data1.getColor());
        metals.select(data1.getMetals());

        cleanUpVegetables();
        JsonArray arrayListVegetables = data1.getVegetables().getAsJsonArray();
        for (JsonElement veget:arrayListVegetables) {
            vegetables.select(String.valueOf(veget));
        }

    }

    public void selectData2(Data2 data2) {
        JsonArray arrayList = data2.getElements().getAsJsonArray();

        summaryTop.select(String.valueOf(data2.getSummary().getAsJsonArray().get(0)));
        summaryBottom.select(String.valueOf(data2.getSummary().getAsJsonArray().get(1)));

        if (arrayList.size() == 2) {
            elementChecklist.select(String.valueOf(arrayList.get(0)));
            elementChecklist.select(String.valueOf(arrayList.get(1)));
        } else {
            elementChecklist.select(String.valueOf(arrayList.get(0)));
            elementChecklist.select(String.valueOf(arrayList.get(1)));
            elementChecklist.select(String.valueOf(arrayList.get(2)));
            elementChecklist.select(String.valueOf(arrayList.get(3)));
        }

        colors.select(data2.getColor());
        metals.select(data2.getMetals());

        JsonArray arrayListVegetables = data2.getVegetables().getAsJsonArray();
        cleanUpVegetables();
        for (JsonElement veget:arrayListVegetables) {
            vegetables.select(String.valueOf(veget));
        }

    }

    public void selectData3(Data3 data3) {
        summaryTop.select(String.valueOf(data3.getSummary().getAsJsonArray().get(0)));
        summaryBottom.select(String.valueOf(data3.getSummary().getAsJsonArray().get(1)));

        JsonArray arrayList = data3.getElements().getAsJsonArray();
        if (arrayList.size() == 2) {
            elementChecklist.select(String.valueOf(arrayList.get(0)));
            elementChecklist.select(String.valueOf(arrayList.get(1)));
        } else {
            elementChecklist.select(String.valueOf(arrayList.get(0)));
            elementChecklist.select(String.valueOf(arrayList.get(1)));
            elementChecklist.select(String.valueOf(arrayList.get(2)));
            elementChecklist.select(String.valueOf(arrayList.get(3)));
        }

        colors.select(data3.getColor());
        metals.select(data3.getMetals());

        cleanUpVegetables();
        JsonArray arrayListVegetables = data3.getVegetables().getAsJsonArray();
        for (JsonElement veget:arrayListVegetables) {
            vegetables.select(String.valueOf(veget));
        }

    }

    public void selectData4(Data4 data4) {
        summaryTop.select(String.valueOf(data4.getSummary().getAsJsonArray().get(0)));
        summaryBottom.select(String.valueOf(data4.getSummary().getAsJsonArray().get(1)));

        JsonArray arrayList = data4.getElements().getAsJsonArray();
        if (arrayList.size() == 2) {
            elementChecklist.select(String.valueOf(arrayList.get(0)));
            elementChecklist.select(String.valueOf(arrayList.get(1)));
        } else {
            elementChecklist.select(String.valueOf(arrayList.get(0)));
            elementChecklist.select(String.valueOf(arrayList.get(1)));
            elementChecklist.select(String.valueOf(arrayList.get(2)));
            elementChecklist.select(String.valueOf(arrayList.get(3)));
        }

        colors.select(data4.getColor());
        metals.select(data4.getMetals());

        cleanUpVegetables();
        JsonArray arrayListVegetables = data4.getVegetables().getAsJsonArray();
        for (JsonElement veget:arrayListVegetables) {
            vegetables.select(String.valueOf(veget));
        }

    }

    public void selectData5(Data5 data5) {
        summaryTop.select(String.valueOf(data5.getSummary().getAsJsonArray().get(0)));
        summaryBottom.select(String.valueOf(data5.getSummary().getAsJsonArray().get(1)));

        JsonArray arrayList = data5.getElements().getAsJsonArray();
        if (arrayList.size() == 2) {
            elementChecklist.select(String.valueOf(arrayList.get(0)));
            elementChecklist.select(String.valueOf(arrayList.get(1)));
        } else {
            elementChecklist.select(String.valueOf(arrayList.get(0)));
            elementChecklist.select(String.valueOf(arrayList.get(1)));
            elementChecklist.select(String.valueOf(arrayList.get(2)));
            elementChecklist.select(String.valueOf(arrayList.get(3)));
        }

        colors.select(data5.getColor());
        metals.select(data5.getMetals());

        cleanUpVegetables();
        JsonArray arrayListVegetables = data5.getVegetables().getAsJsonArray();
        for (JsonElement veget:arrayListVegetables) {
            vegetables.select(String.valueOf(veget));
        }

    }

    public void cleanUpVegetables() {
        vegetables.expand();
        vegetableCheckBox.click();
    }

    public void pressSubmitBtn() {
        submit.click();
    }

    public String assertResults() {
        return assertRow
                .stream().map(WebElement::getText).collect(Collectors.toList()).get(0);
    }
}