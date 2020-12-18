package hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class SubtractionDataProvider {

    @DataProvider(name = "Subtraction data provider")
    public Object[][] subtractionDataProvider() {
        return new Object[][] {
                {2, 2, 0},
                {3, 4, -1},
                {6, 9, -3},
                {2, 5, -3}
        };
    }
}
