package hw5.services.page.component;

public class RadioButton {

    private static RadioButton instance;
    private static String name;

    private RadioButton(String name) {
        this.name = name;
    }

    public static RadioButton getInstance(String name) {
        return instance == null ? instance = new RadioButton(name) : instance;
    }

    public static String getName() {
        return name;
    }
}