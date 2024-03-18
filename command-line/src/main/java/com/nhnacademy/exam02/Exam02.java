package com.nhnacademy.exam02;

public class Exam02 {
    public static void main(String[] args) {
        for (String arg : args) {
            // 정규표현식
            // if (arg.matches("[+-]?(0|[1-9]\\d{0,9})")) {
            if (arg.matches("^\\s*[+-]?(0|[1-9]\\d{0,9})\\s*$")) { // 양 끝 공백은 허용, 시작부터 끝까지 정수만
                System.out.println("Integer: " + arg.trim());
            } else {
                System.out.println("String: " + arg);
            }
        }
    }
}
