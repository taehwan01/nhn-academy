package com.nhnacademy.exam.exam03;

public class Person {
    String name;
    String address;

    public Person(String name) {
        this.name = name;
    }

    public String getName2() {
        return name;
    }

    public String getAccessAddress() {
        return "wheeee";
    }

    public void setName(String name) {
        this.name = name;
    }

}
