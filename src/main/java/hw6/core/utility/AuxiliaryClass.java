package hw6.core.utility;

import hw6.core.pages.elements.composite.pageentity.UserEntity;
import org.testng.asserts.SoftAssert;

public class AuxiliaryClass {
    protected static SoftAssert softAssert = new SoftAssert();

    protected static UserEntity ROMAN = new UserEntity("Roman", "Jdi1234");
}