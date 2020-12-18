package hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class SumDataProvider {

    @DataProvider(name = "Sum data provider")
    public Object[][] sumDataProvider() {
        return new Object[][] {
                {2, 2, 4},
                {3, 4, 7},
                {6, 9, 15},
                {2, 5, 7}
        };
    }
}
