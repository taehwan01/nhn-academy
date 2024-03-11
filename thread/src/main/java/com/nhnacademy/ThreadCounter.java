package com.nhnacademy;

import java.time.LocalTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadCounter extends Thread {
    private String name;
    private int count;
    private int maxCount;

    Logger logger = LogManager.getLogger();

    public ThreadCounter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
        this.count = 0;
    }

    @Override
    public void run() {
        while (count < maxCount) {
            try {
                Thread.sleep(100);
                count++;
                logger.trace("{} : {}", name, count);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // 지금 실행하고 있는 스레드, 이거를 멈춰라.
            }
        }
    }

    public static void main(String[] args) {
        ThreadCounter threadCounter1 = new ThreadCounter("threadCounter1", 10);
        ThreadCounter threadCounter2 = new ThreadCounter("threadCounter2", 10);

        System.out.println("start: " + LocalTime.now());
        threadCounter1.start();
        threadCounter2.start();
        System.out.println("end: " + LocalTime.now());
        // start, end 먼저 출력되고, threadCounter1, 2가 출력됨
        // 왜? start, end는 main 스레드에서 실행되고, threadCounter1, 2는 새로운 스레드에서 실행되기 때문
    }
}
