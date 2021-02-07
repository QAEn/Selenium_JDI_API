package hw8.utility;

import java.util.ResourceBundle;

public class GetProperties {

    private ResourceBundle testData;
    private ResourceBundle address;

    public enum NameOfProperty {
        TEST_DATA,
        ADDRESS
    }

    public GetProperties(NameOfProperty numberOfExercise) {
        switch (numberOfExercise) {
            case TEST_DATA:
                testData = ResourceBundle.getBundle("hw8/properties/testdata");
                break;
            case ADDRESS:
                address = ResourceBundle.getBundle("hw8/properties/address");
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
        return address.getString(resourceName);
    }
}