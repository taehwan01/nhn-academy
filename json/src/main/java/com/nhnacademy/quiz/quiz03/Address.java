package com.nhnacademy.quiz.quiz03;

public class Address {
    private int code;

    private String city;

    public Address(int code, String city) {
        this.code = code;
        this.city = city;
    }

    public int getCode() {
        return code;
    }

    public String getCity() {
        return city;
    }
}
