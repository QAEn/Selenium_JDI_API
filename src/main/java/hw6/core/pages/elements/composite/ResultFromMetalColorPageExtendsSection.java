package hw6.core.pages.elements.composite;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

import java.util.ArrayList;
import java.util.List;

public class ResultFromMetalColorPageExtendsSection extends Section {

    @UI(".summ-res")
    private UIElement summary;

    @UI(".elem-res")
    private UIElement elements;

    @UI(".col-res")
    private UIElement color;

    @UI(".met-res")
    private UIElement metals;

    @UI(".sal-res")
    private UIElement vegetables;

    public Integer getSummary() {
        return Integer.parseInt(getResult(summary.getText()).get(0).trim());
    }

    public List<String> getElements() {
        return new ArrayList<>(getResult(elements.getText()));
    }

    public String getColor() {
        return getResult(color.getText()).get(0).trim();
    }

    public String getMetals() {
        return getResult(metals.getText()).get(0).trim();
    }

    public List<String> getVegetables() {
        return new ArrayList<>(getResult(vegetables.getText()));
    }

    private List<String> getResult(String particularResult) {
        List<String> items = new ArrayList<>();

        int i = 0;

        for (String string : particularResult.split(" ")) {
            if (i > 0) {
                String item = string.replaceAll(",", "");
                items.add(item);
            }
            i++;
        }
        return items;
    }
}