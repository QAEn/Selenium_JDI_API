package hw5.services.utility;

import java.util.ResourceBundle;

public class GetProperties {

    private ResourceBundle myBundle;

    public enum NameOfProperty {
        EXERCISE,
        EXERCISE_DATA
    }

    public GetProperties(NameOfProperty numberOfExercise) {
        switch (numberOfExercise) {
            case EXERCISE:
                myBundle = ResourceBundle.getBundle("hw5/properties/exercise");
                break;
            case EXERCISE_DATA:
                myBundle = ResourceBundle.getBundle("hw5/testdata/data");
                break;
            default:
                System.out.println("The resource isn't selected");
                break;
        }
    }

    public String getResource(String resourceName) {
        return myBundle.getString(resourceName);
    }
}