package hw5.services.dataprovider;

import hw5.services.utility.GetProperties;
import static hw5.services.utility.GetProperties.NameOfProperty.EXERCISE_DATA;

public class TestDataProvider {

    private final GetProperties getExerciseDataProperties = new GetProperties(EXERCISE_DATA);

    private final String expectedTitleName = getExerciseDataProperties
            .getResource("titleName");
    private final String loginUserName = getExerciseDataProperties
            .getResource("loginUserName");
    private final String password = getExerciseDataProperties
            .getResource("password");
    private final String assertTitle = getExerciseDataProperties
            .getResource("assertTitle");

    public String getAssertTitle() {
        return assertTitle;
    }

    public String getExpectedTitleName() {
        return expectedTitleName;
    }

    public String getLoginUserName() {
        return loginUserName;
    }

    public String getPassword() {
        return password;
    }

}
