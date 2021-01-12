package hw4.baseclass.dataprovider;

import hw4.baseclass.utility.GetProperties;
import org.testng.annotations.DataProvider;
import java.util.Arrays;
import java.util.List;
import static hw4.baseclass.utility.GetProperties.NameOfProperty.EXERCISE_DATA;

public class AssertDataProvider {

    @DataProvider(name = "assertTextDataSet")
    public Object[][] assertTextDataSet() {
        return new Object[][]{
                {"To include good practices\nand ideas from successful\nEPAM project",
                        "To be flexible and\ncustomizable",
                        "To be multiplatform",
                        "Already have good base\n(about 20 internal "
                                + "and\nsome external projects),\nwish to get more…"}
        };
    }

    private final GetProperties getExerciseDataProperties = new GetProperties(EXERCISE_DATA);

    private final String expectedIframeWithButton = getExerciseDataProperties
            .getResource("iframeWithButtonExists");
    private final String expectedAssertLeftSectionItems = getExerciseDataProperties
            .getResource("assertLeftSectionItems");
    private final String expectedTitleName = getExerciseDataProperties
            .getResource("titleName");
    private final String loginUserName = getExerciseDataProperties
            .getResource("loginUserName");
    private final String password = getExerciseDataProperties
            .getResource("password");
    private final String assertTitle = getExerciseDataProperties
            .getResource("assertTitle");
    private final List assertHeaderItemsOnHomePage = Arrays.asList(
            getExerciseDataProperties.getResource("assertHeaderItems"));

    public String getExpectedAssertLeftSectionItems() {
        return expectedAssertLeftSectionItems;
    }

    public String getExpectedIframeWithButton() {
        return expectedIframeWithButton;
    }

    public String getAssertTitle() {
        return assertTitle;
    }

    public List getAssertHeaderItemsOnHomePage() {
        return assertHeaderItemsOnHomePage;
    }

    public String getExpectedTitleName() {
        return expectedTitleName;
    }

    public String getLoginUserName() {
        return loginUserName;
    }

    public String getPassword() {
        return password;
    }

}
