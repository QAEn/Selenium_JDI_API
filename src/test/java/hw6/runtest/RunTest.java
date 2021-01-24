package hw6.runtest;

import hw6.TestsInit;
import hw6.core.entities.datafromjsonfile.*;
import hw6.core.utility.*;

import org.testng.annotations.Test;

import static hw6.Site.*;

public class RunTest extends AuxiliaryClass implements TestsInit {


    @Test(dataProvider = "jsonData1", dataProviderClass = DataProviderFromJson.class)
    public void data1Test(Data1 data1) {
        openSite();
        login(ROMAN);
        openMetalColorPage();
        checkData1(data1);
        pressSubmitBtn();
        assertData1(this.data1, softAssert);
    }

    @Test(dataProvider = "jsonData2", dataProviderClass = DataProviderFromJson.class)
    public void data2Test(Data2 data2) {
        openSite();
        login(ROMAN);
        openMetalColorPage();
        checkData2(data2);
        pressSubmitBtn();
        assertData2(this.data2, softAssert);
    }

    @Test(dataProvider = "jsonData3", dataProviderClass = DataProviderFromJson.class)
    public void data3Test(Data3 data3) {
        openSite();
        login(ROMAN);
        openMetalColorPage();
        checkData3(data3);
        pressSubmitBtn();
        assertData3(this.data3, softAssert);
    }

    @Test(dataProvider = "jsonData4", dataProviderClass = DataProviderFromJson.class)
    public void data4Test(Data4 data4) {
        openSite();
        login(ROMAN);
        openMetalColorPage();
        checkData4(data4);
        pressSubmitBtn();
        assertData4(this.data4, softAssert);
    }

    @Test(dataProvider = "jsonData5", dataProviderClass = DataProviderFromJson.class)
    public void data5Test(Data5 data5) {
        openSite();
        login(ROMAN);
        openMetalColorPage();
        checkData5(data5);
        pressSubmitBtn();
        assertData5(this.data5, softAssert);
    }

}