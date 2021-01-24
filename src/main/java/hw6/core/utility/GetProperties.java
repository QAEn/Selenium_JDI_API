package hw6.core.utility;

import java.util.ResourceBundle;

public class GetProperties {

    private ResourceBundle myBundle;

    public enum NameOfProperty {
        EXERCISE_DATA
    }

    public GetProperties(NameOfProperty numberOfExercise) {
        switch (numberOfExercise) {
            case EXERCISE_DATA:
                myBundle = ResourceBundle.getBundle("hw6/properties/test");
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