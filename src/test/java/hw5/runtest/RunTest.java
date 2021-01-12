package hw5.runtest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:hw5/feature"},
        plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}
        //glue = {"src.test.java.hw5.steps"}
        )
public class RunTest extends AbstractTestNGCucumberTests {
}
