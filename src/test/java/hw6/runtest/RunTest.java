package hw6.runtest;

import hw6.TestsInit;
import hw6.core.pages.elements.composite.pageentity.MetalsAndColorsEntity;
import hw6.core.utility.*;

import org.testng.annotations.Test;

import static hw6.Site.*;

public class RunTest extends AuxiliaryClass implements TestsInit {


    @Test(dataProvider = "dataFromSource", dataProviderClass = DataProviderFromJson.class)
    public void dataTest(MetalsAndColorsEntity data) {

        openSite();
        login(ROMAN);
        openMetalColorPage();
        putDataToMetalColorPage(data);
        compareResultsWithInitialData(data);
    }

}