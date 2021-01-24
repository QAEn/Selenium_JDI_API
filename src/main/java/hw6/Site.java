package hw6;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.*;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;

import hw6.core.entities.User;
import hw6.core.entities.datafromjsonfile.*;
import hw6.core.pages.*;

import org.testng.asserts.SoftAssert;

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

    public static void login(User user) {
        openSiteIfItClosed();
        if (!userName.isDisplayed()) {
            homePage.loginJdiSite(user);
        }
    }

    public static void openMetalColorPage() {
        homePage.getHeader().select(Pages.METALS_COLORS);
    }

    public static void checkData1(Data1 data1) {
        metalColorPage.selectData1(data1);
    }

    public static void checkData2(Data2 data2) {
        metalColorPage.selectData2(data2);
    }

    public static void checkData3(Data3 data3) {
        metalColorPage.selectData3(data3);
    }

    public static void checkData4(Data4 data4) {
        metalColorPage.selectData4(data4);
    }

    public static void checkData5(Data5 data5) {
        metalColorPage.selectData5(data5);
    }

    public static void pressSubmitBtn() {
        metalColorPage.pressSubmitBtn();
    }

    public static void assertData1(String expectedData, SoftAssert softAssert) {
        String actual = metalColorPage.assertResults();

        softAssert.assertEquals(actual, expectedData,
                "\n>>> Incorrect DATA_1 <<<\n"
        );

        softAssert.assertAll();
    }

    public static void assertData2(String expectedData, SoftAssert softAssert) {
        String actual = metalColorPage.assertResults();

        softAssert.assertEquals(actual, expectedData,
                "\n>>> Incorrect DATA_2 <<<\n"
        );

        softAssert.assertAll();
    }

    public static void assertData3(String expectedData, SoftAssert softAssert) {
        String actual = metalColorPage.assertResults();

        softAssert.assertEquals(actual, expectedData,
                "\n>>> Incorrect DATA_3 <<<\n"
        );

        softAssert.assertAll();
    }

    public static void assertData4(String expectedData, SoftAssert softAssert) {
        String actual = metalColorPage.assertResults();

        softAssert.assertEquals(actual, expectedData,
                "\n>>> Incorrect DATA_4 <<<\n"
        );

        softAssert.assertAll();
    }

    public static void assertData5(String expectedData, SoftAssert softAssert) {
        String actual = metalColorPage.assertResults();

        softAssert.assertEquals(actual, expectedData,
                "\n>>> Incorrect DATA_5 <<<\n"
        );

        softAssert.assertAll();
    }

    private static void openSiteIfItClosed() {
        if (!WebPage.getUrl().contains("https://jdi-testing.github.io/jdi-light/")) {
            homePage.open();
        }
    }
}