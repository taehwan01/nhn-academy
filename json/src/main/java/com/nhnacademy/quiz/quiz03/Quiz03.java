package com.nhnacademy.quiz.quiz03;

import org.json.JSONObject;

public class Quiz03 {
    public static void main(String[] args) {
        Address address = new Address(12345, "GwangJu");
        Person person = new Person("monte", address);

        JSONObject monte = new JSONObject(person);
        System.out.println(monte);
    }
}
