package hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class DivisionDataProvider {

    @DataProvider(name = "Division data provider")
    public Object[][] divisionDataProvider() {
        return new Object[][] {
                {2, 2, 1},
                {3, 4, 0.75},
                {6, 9, 0.6},
                {2, 5, 0.4}
        };
    }
}
