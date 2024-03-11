package com.nhnacademy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Counter {
    private String name;
    private int count;
    private int maxCount;

    Logger logger = LogManager.getLogger();

    public Counter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
    }

    public void run() {
        while (count < maxCount && !Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(100);
                logger.trace("{} : {}", name, ++count);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // 지금 실행하고 있는 스레드, 이거를 멈춰라.
            }
        }
    }

    public static void main(String[] args) {
        Counter counter1 = new Counter("counter1", 10);
        Counter counter2 = new Counter("counter2", 10);
        counter1.run();
        counter2.run();
    }
}
