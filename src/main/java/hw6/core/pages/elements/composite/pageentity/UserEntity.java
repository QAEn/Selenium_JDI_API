package hw6.core.pages.elements.composite.pageentity;

import com.epam.jdi.tools.DataClass;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserEntity extends DataClass<UserEntity> {

    private String name;
    private String password;

}