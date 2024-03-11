package com.nhnacademy;

import java.time.LocalTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Runnable Interface
public class RunnableCounter implements Runnable {
    private String name;
    private int count;
    private int maxCount;

    Logger logger = LogManager.getLogger();

    public RunnableCounter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
        count = 0;
    }

    public int getCount() {
        return this.count;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted() && count < maxCount) {
            try {
                Thread.sleep(100);
                count++;
                // if (count >= 5) {
                // Thread.currentThread().interrupt(); // 종료
                // }
                logger.trace("{} : {}", name, count);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        RunnableCounter counter1 = new RunnableCounter("counter1", 10);
        RunnableCounter counter2 = new RunnableCounter("counter2", 10);
        Thread thread1 = new Thread(counter1); // Runnable 을 구현했다고 스스로 실행되는 것이 아니고, 이를 실행시켜줄 애(스레드)가 있어야함
        Thread thread2 = new Thread(counter2);

        System.out.println("start: " + LocalTime.now() + "\n");

        thread1.start();
        thread2.start();

        while (thread1.isAlive() || thread2.isAlive()) {
            if (counter1.getCount() >= 3) {
                thread1.interrupt(); // count1을 실행시키고 있는 스레드를 종료
            }
            if (counter2.getCount() >= 7) {
                thread2.interrupt();
            }
        }

        System.out.println("end: " + LocalTime.now() + "\n");

    }
}
