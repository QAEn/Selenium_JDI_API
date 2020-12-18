package hw3.baseclass;

import java.util.ResourceBundle;

public class GetProperties {

    private ResourceBundle myBundle;

    public enum NumberOfExercise {
        FIRST_EXERCISE,
        SECOND_EXERCISE
    }

    public GetProperties(NumberOfExercise numberOfExercise) {
        switch (numberOfExercise) {
            case FIRST_EXERCISE:
                myBundle = ResourceBundle.getBundle("hw3/properties/exercise_1");
                break;
            case SECOND_EXERCISE:
                myBundle = ResourceBundle.getBundle("hw3/properties/exercise_2");
                break;
            default:
                //уточнить как элегантно обработать кэйс по умолчанию
                System.out.println("The resource isn't selected");
                break;
        }
    }

    public String getResource(String resourceName) {
        String resource = myBundle.getString(resourceName);
        return resource;
    }
}