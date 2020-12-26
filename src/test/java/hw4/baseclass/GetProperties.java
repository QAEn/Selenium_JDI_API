package hw4.baseclass;

import java.util.ResourceBundle;

public class GetProperties {

    private ResourceBundle myBundle;

    public enum NameOfProperty {
        EXERCISE,
        USER_DATA,
        EXERCISE_DATA
    }

    public GetProperties(NameOfProperty numberOfExercise) {
        switch (numberOfExercise) {
            case EXERCISE:
                myBundle = ResourceBundle.getBundle("hw4/properties/exercise");
                break;
            case USER_DATA:
                myBundle = ResourceBundle.getBundle("hw4/properties/userdata");
                break;
            case EXERCISE_DATA:
                myBundle = ResourceBundle.getBundle("hw4/testdata/data");
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