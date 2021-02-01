package hw6.core.pages.elements.composite;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.*;

import hw6.core.pages.elements.composite.pageentity.UserEntity;

public class LoginExtendsForm extends Form<UserEntity> {

    @FindBy(id = "name")
    public TextField name;

    @FindBy(id = "password")
    public TextField password;

}
