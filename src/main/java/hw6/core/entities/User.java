package hw6.core.entities;

import com.epam.jdi.tools.DataClass;

public class User extends DataClass<User> {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}