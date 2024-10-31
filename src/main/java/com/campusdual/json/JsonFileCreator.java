package com.campusdual.json;

import com.campusdual.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonFileCreator {

    private static void createFile(){
        JsonObject computer = new JsonObject();
        JsonArray componentsArray = new JsonArray();
        JsonObject component1 = new JsonObject();
        componentsArray.add(JsonFileCreator.createItem(2, "Graphic card"));
        componentsArray.add(JsonFileCreator.createItem(1, "CPU"));
        componentsArray.add(JsonFileCreator.createItem(3, "Fan"));
        componentsArray.add(JsonFileCreator.createItem(1, "Motherboard"));
        componentsArray.add(JsonFileCreator.createItem(2, "RAM"));
        componentsArray.add(JsonFileCreator.createItem(2, "SSD"));
        componentsArray.add(JsonFileCreator.createItem(1, "Power supply"));
        componentsArray.add(JsonFileCreator.createItem(1, "Computer case"));
        computer.add("components", componentsArray);

        try (FileWriter fw = new FileWriter ("src/main/resources/computerList/json")) {
            //Without format
            // ===============
            //fw.write(computer.toString());
            //With format
            //===============
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(computer);
            fw.write(json);
            // =============
            fw.flush();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static JsonObject createItem(int quantity, String itemDesc){
        JsonObject component = new JsonObject();
        component.addProperty("quantity", quantity);
        component.addProperty("text", itemDesc);
        return component;
    }

    public static void main(String[] args) {
        JsonFileCreator.createFile();

    }
}
