package com.nhnacademy.exam;

import org.json.JSONObject;

public class Exam05 {
    public static void main(String[] args) {
        JSONObject object = new JSONObject();

        object.put("name", "monte");
        object.put("age", 26);

        System.out.println(object);
        Object nameObject = object.get("name");
        System.out.println(nameObject);
        System.out.println("Name type: " + nameObject.getClass().getTypeName());
        if (nameObject instanceof String) {
            System.out.println("Name is String");
        }

        Object ageObject = object.get("age");
        // System.out.println("Age type: " + object.getString("age")); // 에러
    }
}
