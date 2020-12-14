package hw1.operationchecktest;

import hw1.dataproviders.SubtractionDataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class SubtractionTest extends AbstractCalculatorTest {

    @Test(
            description = "Test for approve subtraction functional, Jira binding cab be here",
            dataProvider = "Subtraction data provider",
            dataProviderClass = SubtractionDataProvider.class
    )
    public void dataProvSubtractionTest(long firstNumber, long secondNumber, long expectedResult) {
        long actualResult = calculator.sub(firstNumber, secondNumber);
        assertEquals(actualResult, expectedResult);
    }
}
