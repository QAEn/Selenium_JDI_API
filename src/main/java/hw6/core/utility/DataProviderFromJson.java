package hw6.core.utility;

import hw6.core.entities.*;

import org.testng.annotations.DataProvider;

public class DataProviderFromJson {

    @DataProvider(name = "jsonData1")
    public Object[][] jsonData1() {
        return new Object[][]{{JsonObjectData.firstData()}};
    }

    @DataProvider(name = "jsonData2")
    public Object[][] jsonData2() {
        return new Object[][]{{JsonObjectData.secondData()}};
    }

    @DataProvider(name = "jsonData3")
    public Object[][] jsonData3() {
        return new Object[][]{{JsonObjectData.thirdData()}};
    }

    @DataProvider(name = "jsonData4")
    public Object[][] jsonData4() {
        return new Object[][]{{JsonObjectData.fourthData()}};
    }

    @DataProvider(name = "jsonData5")
    public Object[][] jsonData5() {
        return new Object[][]{{JsonObjectData.fifthData()}};
    }
}