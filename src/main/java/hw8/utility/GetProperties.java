package hw8.utility;

import java.util.ResourceBundle;

public class GetProperties {

    private ResourceBundle testData;
    private ResourceBundle uri;

    public enum NameOfProperty {
        TEST_DATA,
        URI
    }

    public GetProperties(NameOfProperty numberOfExercise) {
        switch (numberOfExercise) {
            case TEST_DATA:
                testData = ResourceBundle.getBundle("hw8/properties/testdata");
                break;
            case URI:
                uri = ResourceBundle.getBundle("hw8/properties/uri");
                break;
            default:
                System.err.println("The resource isn't selected");
                break;
        }
    }

    public String getTestData(String resourceName) {
        return testData.getString(resourceName);
    }

    public String getUri(String resourceName) {
        return uri.getString(resourceName);
    }
}