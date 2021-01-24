package hw6.core.jsonreader;

import com.google.gson.*;

import java.io.*;

import java.util.*;

public class ReadFromJson {
    JsonParser parser = new JsonParser();
    String pathToJsonFile = "hw6/testdata/JDI_ex8_metalsColorsDataSet.json";

    InputStream inputStream = getClass()
            .getClassLoader()
            .getResourceAsStream(pathToJsonFile);

    Reader reader = new InputStreamReader(inputStream);

    JsonElement rootElement = parser.parse(reader);

    JsonObject rootObject = rootElement.getAsJsonObject();

    public List<JsonObject> getObjectData() {
        List<JsonObject> listObjectData = new ArrayList<>();

        JsonObject data1 = rootObject.getAsJsonObject("data_1");
        JsonObject data2 = rootObject.getAsJsonObject("data_2");
        JsonObject data3 = rootObject.getAsJsonObject("data_3");
        JsonObject data4 = rootObject.getAsJsonObject("data_4");
        JsonObject data5 = rootObject.getAsJsonObject("data_5");
        JsonObject data6 = rootObject.getAsJsonObject("data_6");

        listObjectData.add(data1);
        listObjectData.add(data2);
        listObjectData.add(data3);
        listObjectData.add(data4);
        listObjectData.add(data5);
        listObjectData.add(data6);

        return listObjectData;
    }
}