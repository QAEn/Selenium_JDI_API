package hw6.core.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

import hw6.core.pages.elements.composite.LoginExtendsForm;

import hw6.core.pages.elements.composite.pageentity.UserEntity;
import lombok.Getter;

@Getter
public class HomePage extends WebPage {

    @FindBy(id = "user-icon")
    private Label label;

    @FindBy(css = ".nav")
    public Menu header;

    private LoginExtendsForm loginCompositeForm;

    public void loginJdiSite(UserEntity user) {
        label.click();
        loginCompositeForm.loginAs(user);
    }
}