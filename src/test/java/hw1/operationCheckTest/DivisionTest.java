package hw1.operationCheckTest;

import hw1.dataProviders.DivisionDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivisionTest extends AbstractCalculatorTest {

    @Test(
            description = "Test for approve sum functional, Jira binding cab be here",
            dataProvider = "Division data provider",
            dataProviderClass = DivisionDataProvider.class
    )
    public void dataProviderDivisionTest(double firstNumber, double secondNumber, double expectedResult) {
        double actualResult = calculator.div(firstNumber, secondNumber);
        assertEquals(actualResult, expectedResult, 0.1);
    }
}
