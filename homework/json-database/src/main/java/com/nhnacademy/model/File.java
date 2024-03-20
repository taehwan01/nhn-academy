package com.nhnacademy.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class File {
    JSONObject data;

    public File() {
        try {
            FileReader reader = new FileReader("data.json");
            data = new JSONObject(reader);
            reader.close();
        } catch (Exception e) {
            data = new JSONObject();
        }
    }

    public JSONObject getData() {
        return data;
    }

    public void saveData(JSONObject newData) throws IOException {
        data = newData;
        FileWriter writer = new FileWriter("data.json");
        writer.write(data.toString());
        writer.flush();
        writer.close();
    }
}
