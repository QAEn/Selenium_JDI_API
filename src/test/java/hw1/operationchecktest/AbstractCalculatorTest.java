package hw1.operationchecktest;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractCalculatorTest {
    protected Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void calculatorSetupTest() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void calculatorBreakTest() {
        calculator = null;
    }
}
