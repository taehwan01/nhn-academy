package com.nhnacademy;

public class Log {
    private static int count;
    private int id = ++count;
    private String time;
    private String message;

    public Log(String time, String message) {
        this.time = time;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }
}
