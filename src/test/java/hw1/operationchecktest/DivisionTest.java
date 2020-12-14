package hw1.operationchecktest;

import hw1.dataproviders.DivisionDataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class DivisionTest extends AbstractCalculatorTest {

    @Test(
            description = "Test for approve division functional, Jira binding cab be here",
            dataProvider = "Division data provider",
            dataProviderClass = DivisionDataProvider.class
    )
    public void dataProvDivTest(double firstNumber, double secondNumber, double expectedResult) {
        double actualResult = calculator.div(firstNumber, secondNumber);
        assertEquals(actualResult, expectedResult, 0.1);
    }
}
