package hw6.core.utility;

import hw6.core.entities.User;
import org.testng.asserts.SoftAssert;

import static hw6.core.utility.GetProperties.NameOfProperty.EXERCISE_DATA;

public class AuxiliaryClass {
    protected static SoftAssert softAssert = new SoftAssert();

    protected static User ROMAN = new User("Roman", "Jdi1234");

    private  GetProperties getExerciseProperties = new GetProperties(EXERCISE_DATA);

    protected String data1 = getExerciseProperties.getResource("data1");
    protected String data2 = getExerciseProperties.getResource("data2");
    protected String data3 = getExerciseProperties.getResource("data3");
    protected String data4 = getExerciseProperties.getResource("data4");
    protected String data5 = getExerciseProperties.getResource("data5");
}