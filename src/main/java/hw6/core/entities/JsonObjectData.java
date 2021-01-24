package hw6.core.entities;

import hw6.core.entities.datafromjsonfile.*;


public class JsonObjectData {

    private static ExistingDataJsonObject existingDataJsonObject = new ExistingDataJsonObject();

    public static Data1 firstData() {
        Data1 data1 = new Data1(
                existingDataJsonObject.getJsonData().get(0).get("summary"),
                existingDataJsonObject.getJsonData().get(0).get("elements"),
                String.valueOf(existingDataJsonObject.getJsonData().get(0).get("color")),
                String.valueOf(existingDataJsonObject.getJsonData().get(0).get("metals")),
                existingDataJsonObject.getJsonData().get(0).get("vegetables")
        );
        return data1;
    }

    public static Data2 secondData() {
        Data2 data2 = new Data2(
                existingDataJsonObject.getJsonData().get(1).get("summary"),
                existingDataJsonObject.getJsonData().get(1).get("elements"),
                String.valueOf(existingDataJsonObject.getJsonData().get(1).get("color")),
                String.valueOf(existingDataJsonObject.getJsonData().get(1).get("metals")),
                existingDataJsonObject.getJsonData().get(1).get("vegetables")
        );
        return data2;
    }

    public static Data3 thirdData() {
        Data3 data3 = new Data3(
                existingDataJsonObject.getJsonData().get(2).get("summary"),
                existingDataJsonObject.getJsonData().get(2).get("elements"),
                String.valueOf(existingDataJsonObject.getJsonData().get(2).get("color")),
                String.valueOf(existingDataJsonObject.getJsonData().get(2).get("metals")),
                existingDataJsonObject.getJsonData().get(2).get("vegetables")
        );
        return data3;
    }

    public static Data4 fourthData() {
        Data4 data4 = new Data4(
                existingDataJsonObject.getJsonData().get(3).get("summary"),
                existingDataJsonObject.getJsonData().get(3).get("elements"),
                String.valueOf(existingDataJsonObject.getJsonData().get(3).get("color")),
                String.valueOf(existingDataJsonObject.getJsonData().get(3).get("metals")),
                existingDataJsonObject.getJsonData().get(3).get("vegetables")
        );
        return data4;
    }

    public static Data5 fifthData() {
        Data5 data5 = new Data5(
                existingDataJsonObject.getJsonData().get(4).get("summary"),
                existingDataJsonObject.getJsonData().get(4).get("elements"),
                String.valueOf(existingDataJsonObject.getJsonData().get(4).get("color")),
                String.valueOf(existingDataJsonObject.getJsonData().get(4).get("metals")),
                existingDataJsonObject.getJsonData().get(4).get("vegetables")
        );
        return data5;
    }

}