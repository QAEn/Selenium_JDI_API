package hw6.core.entities;

import com.google.gson.*;

import hw6.core.jsonreader.ReadFromJson;

import java.util.List;

public class ExistingDataJsonObject {

    protected ReadFromJson readFromJson = new ReadFromJson();

    public List<JsonObject> getJsonData() {
        return readFromJson.getObjectData();
    }

}