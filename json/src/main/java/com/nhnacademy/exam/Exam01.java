package com.nhnacademy.exam;

import org.json.JSONObject;

public class Exam01 {
    public static void main(String[] args) {
        JSONObject object = new JSONObject();

        // map과 동일하나 key는 언제나 String
        object.put("name", "NHN Academy");
        object.put("name", "monte"); // 수정
        object.put("id", "202406032");
        object.put("address", "광주 조선대학교");

        System.out.println(object.optInt("id", 1234));
        // System.out.println(object);
    }
}
