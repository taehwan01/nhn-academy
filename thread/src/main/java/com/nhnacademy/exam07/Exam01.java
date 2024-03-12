package com.nhnacademy.exam07;

public class Exam01 {

    public static void main(String[] args) throws InterruptedException {
        SharedCount sharedCount = new SharedCount();
        SharedCounter counter1 = new SharedCounter("counter1", 10000, sharedCount);
        SharedCounter counter2 = new SharedCounter("counter2", 10000, sharedCount);

        counter1.start();
        counter2.start();

        // counter1과 counter2 중 하나라도 BLOCKED 출력하도록
        while (counter1.isAlive() && counter2.isAlive()) {
            System.out.println(counter1.getState() + ", " + counter2.getState());
            Thread.sleep(1000);
        }
    }
}
