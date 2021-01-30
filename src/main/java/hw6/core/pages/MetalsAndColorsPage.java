package hw6.core.pages;

import hw6.core.pages.elements.composite.ResultFromMetalColorPageExtendsSection;
import hw6.core.pages.elements.composite.MetalsAndColorsExtendsForm;
import hw6.core.pages.elements.composite.pageentity.MetalsAndColorsEntity;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

import org.openqa.selenium.WebElement;

import java.util.List;

public class MetalsAndColorsPage extends WebPage {


    private MetalsAndColorsExtendsForm metalsAndColorsCompositeForm;

    @FindBy(css = ".results li")
    private List<WebElement> result;

    @FindBy(xpath = "//div[@name='log-sidebar']")
    private ResultFromMetalColorPageExtendsSection resultFromMetalColorPage;

    public void fillMetalAndColorForm(MetalsAndColorsEntity metalsAndColorsEntity) {
        metalsAndColorsCompositeForm.fill(metalsAndColorsEntity);
    }

    public ResultFromMetalColorPageExtendsSection getResultFromMetalColorPage() {
        return resultFromMetalColorPage;
    }
}