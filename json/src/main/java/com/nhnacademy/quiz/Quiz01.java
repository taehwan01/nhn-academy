package com.nhnacademy.quiz;

import org.json.JSONObject;

public class Quiz01 {
    public static void main(String[] args) {
        JSONObject object = new JSONObject();
        JSONObject cityObject = new JSONObject();

        cityObject.put("code", 13487);
        cityObject.put("city", "Seongnam");

        object.put("address", cityObject);
        object.put("name", "nhn");

        System.out.println(object);
    }
}
