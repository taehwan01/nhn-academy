package com.nhnacademy.exam07;

public class Exam01 {
    public static void main(String[] args) throws InterruptedException {
        SharedCount sharedCount = new SharedCount();
        SharedCounter counter1 = new SharedCounter("counter1", 10, sharedCount);
        SharedCounter counter2 = new SharedCounter("counter2", 10, sharedCount);

        counter1.start();
        counter2.start();

        System.out.println("sharedCount : " + sharedCount.getCount());
    }
}
