package hw6;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.*;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;

import hw6.core.pages.elements.composite.pageentity.*;
import hw6.core.pages.*;

import static org.testng.Assert.*;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class Site {

    @Css(".profile-photo [ui=label]")
    public static UIElement userName;

    @Url("index.html")
    public static HomePage homePage;

    @Url("metals-colors.html")
    public static MetalsAndColorsPage metalColorPage;

    public static void openSite() {
        homePage.open();
    }

    public static void login(UserEntity user) {
        openSiteIfItClosed();
        if (!userName.isDisplayed()) {
            homePage.loginJdiSite(user);
        }
    }

    public static void openMetalColorPage() {
        homePage.getHeader().select(Pages.METALS_COLORS);
    }

    private static void openSiteIfItClosed() {
        if (!WebPage.getUrl().contains("https://jdi-testing.github.io/jdi-light/")) {
            homePage.open();
        }
    }

    public static void putDataToMetalColorPage(MetalsAndColorsEntity metalsAndColorsEntity) {
        metalColorPage.fillMetalAndColorForm(metalsAndColorsEntity);
    }

    private static MetalsAndColorsEntity getDataFromMetalColorPageExceptSummary() {

        MetalsAndColorsEntity metalsAndColorsEntityActual = new MetalsAndColorsEntity();

        metalsAndColorsEntityActual
                .setColor(metalColorPage.getResultFromMetalColorPage().getColor());

        metalsAndColorsEntityActual
                .setElements(metalColorPage.getResultFromMetalColorPage().getElements());

        metalsAndColorsEntityActual
                .setMetals(metalColorPage.getResultFromMetalColorPage().getMetals());

        metalsAndColorsEntityActual
                .setVegetables(metalColorPage.getResultFromMetalColorPage().getVegetables());

        return metalsAndColorsEntityActual;
    }

    public static void compareResultsWithInitialData(MetalsAndColorsEntity metalsAndColorsEntity) {
        int expectedSummary = metalsAndColorsEntity.getAmount();

        MetalsAndColorsEntity metalsAndColorsEntityActualExceptSummary
                = getDataFromMetalColorPageExceptSummary();

        assertEquals(
                metalColorPage.getResultFromMetalColorPage().getSummary(),
                Integer.valueOf(expectedSummary)
        );

        assertEquals(
                metalsAndColorsEntity, metalsAndColorsEntityActualExceptSummary
        );
    }
}