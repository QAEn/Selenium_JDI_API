package hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class MultiplyDataProvider {

    @DataProvider(name = "Multiply data provider")
    public Object[][] multiplyDataProvider() {
        return new Object[][] {
                {2, 2, 4},
                {3, 4, 12},
                {6, 9, 54},
                {2, 5, 10}
        };
    }
}
