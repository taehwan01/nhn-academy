package com.nhnacademy.quiz;

import org.json.JSONException;
import org.json.JSONObject;

public class Quiz02 {
    public static void main(String[] args) {
        try {
            JSONObject object = new JSONObject();
            String cityJSONString = "{\"code\":13487,\"city\":\"Seongnam\"}";
            JSONObject cityObject = new JSONObject(cityJSONString);

            object.put("address", cityObject);
            object.put("name", "nhn");

            System.out.println(object);
        } catch (JSONException e) {
            System.err.println(e.getMessage());
        }
    }
}
