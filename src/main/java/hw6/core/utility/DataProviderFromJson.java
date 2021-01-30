package hw6.core.utility;

import java.io.*;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import hw6.core.pages.elements.composite.pageentity.MetalsAndColorsEntity;

public class DataProviderFromJson {

    Reader reader;

    {
        try {
            reader = new FileReader(
                    "src/test/resources/hw6/testdata/JDI_ex8_metalsColorsDataSet.json"
            );
        } catch (FileNotFoundException e) {
            System.err.println("\n!!!--->> SourceFileNotFoundException <<---!!!\n");
            e.printStackTrace();
        }
    }

    @DataProvider(name = "dataFromSource")
    public Object[][] jsonData() {

        Map<String, MetalsAndColorsEntity> dataFromJson =
                new Gson().fromJson(
                        reader, new TypeToken<Map<String, MetalsAndColorsEntity>>() {}.getType()
                );

        Object[][] getObject = new Object[dataFromJson.size()][1];
        int i = 0;

        for (String key : dataFromJson.keySet()) {
            getObject[i++][0] = dataFromJson.get(key);
        }

        return getObject;
    }

}