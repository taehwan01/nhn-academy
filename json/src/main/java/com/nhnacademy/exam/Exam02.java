package com.nhnacademy.exam;

import org.json.JSONException;
import org.json.JSONObject;

public class Exam02 {
    public static void main(String[] args) {
        try {
            String jsonString = "{\"name\":\"NHN Academy\"}";
            JSONObject object = new JSONObject(jsonString);

            System.out.println(object);
        } catch (JSONException e) {
            System.err.println(e.getMessage());
        }
    }
}
