package hw5.services.page.component;

public class Dropdown {

    private static Dropdown instance;
    private static String name;

    private Dropdown(String name) {
        this.name = name;
    }

    public static Dropdown getInstance(String name) {
        return instance == null ? instance = new Dropdown(name) : instance;
    }

    public static String getColor() {
        return name;
    }
}
