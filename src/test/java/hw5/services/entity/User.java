package hw5.services.entity;

public class User {

    private static User instance;
    private static String name;
    private static String password;

    private User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public static User getInstance(String name, String password) {
        return instance == null ? instance = new User(name, password) : instance;
    }

    public static String getName() {
        return name;
    }

    public static String getPassword() {
        return password;
    }
}