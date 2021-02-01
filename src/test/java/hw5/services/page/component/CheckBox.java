package hw5.services.page.component;

public class CheckBox {

    private static CheckBox instance;
    private static String firstCheckbox;
    private static String secondCheckbox;

    private CheckBox(String firstCheckbox, String secondCheckbox) {
        this.firstCheckbox = firstCheckbox;
        this.secondCheckbox = secondCheckbox;
    }

    public static CheckBox getInstance(String firstCheckbox, String secondCheckbox) {
        return instance == null ? instance = new CheckBox(firstCheckbox, secondCheckbox) : instance;
    }

    public static String getFirstCheckbox() {
        return firstCheckbox;
    }

    public static String getSecondCheckbox() {
        return secondCheckbox;
    }
}
