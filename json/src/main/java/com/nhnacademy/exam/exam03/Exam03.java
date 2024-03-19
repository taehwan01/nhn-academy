package com.nhnacademy.exam.exam03;

import org.json.JSONObject;

public class Exam03 {
    public static void main(String[] args) {
        Person person = new Person("monte");
        JSONObject p = new JSONObject(person);

        System.out.println(p); // getter가 없으면 그 필드는 JSON으로 변환되지 않는다.
    }
}
