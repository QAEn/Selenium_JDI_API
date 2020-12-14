package hw1.operationchecktest;

import hw1.dataproviders.SumDataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class SumTest extends AbstractCalculatorTest {

    @Test(
            description = "Test for approve sum functional, Jira binding cab be here",
            dataProvider = "Sum data provider",
            dataProviderClass = SumDataProvider.class
    )
    public void dataProviderSumTest(long firstNumber, long secondNumber, long expectedResult) {
        long actualResult = calculator.sum(firstNumber, secondNumber);
        assertEquals(actualResult, expectedResult);
    }
}
