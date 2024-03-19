package com.nhnacademy.exam;

import org.json.JSONTokener;

public class Exam09 {
    public static void main(String[] args) {
        // JSONTokener tokener = new JSONTokener(System.in);
        JSONTokener tokener = new JSONTokener("{\"name\":\"monte\",}");

        while (!tokener.end()) {
            Object object = tokener.nextValue();
            // System.out.println(object.getClass().getTypeName() + " : " + object);
            System.out.println(object);
        }

    }
}