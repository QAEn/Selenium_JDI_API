package hw5.services.dataprovider;

import hw5.services.utility.GetProperties;
import static hw5.services.utility.GetProperties.NameOfProperty.EXERCISE_DATA;

public class TestDataProvider {

    private final GetProperties getExerciseDataProperties = new GetProperties(EXERCISE_DATA);

    private final String password = getExerciseDataProperties
            .getResource("password");

    public String getPassword() {
        return password;
    }
}