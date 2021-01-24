package hw6.core.entities.datafromjsonfile;

import com.google.gson.JsonElement;

public class Data3 {
    protected static JsonElement summary;
    protected JsonElement elements;
    protected String color;
    protected String metals;
    protected JsonElement vegetables;

    public Data3(JsonElement summary, JsonElement elements, String color,
                 String metals, JsonElement vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public JsonElement getSummary() {
        return summary;
    }

    public JsonElement getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public JsonElement getVegetables() {
        return vegetables;
    }
}
