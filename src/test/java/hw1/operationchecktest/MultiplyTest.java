package hw1.operationchecktest;

import hw1.dataproviders.MultiplyDataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class MultiplyTest extends AbstractCalculatorTest {

    @Test(
            description = "Test for approve multiply functional, Jira binding cab be here",
            dataProvider = "Multiply data provider",
            dataProviderClass = MultiplyDataProvider.class
    )
    public void dataProviderMultiplyTest(long firstNumber, long secondNumber, long expectedResult) {
        long actualResult = calculator.mult(firstNumber, secondNumber);
        assertEquals(actualResult, expectedResult);
    }
}
