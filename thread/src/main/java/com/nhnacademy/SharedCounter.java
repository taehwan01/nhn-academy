package com.nhnacademy;

public class SharedCounter extends Thread {
    int count;
    int maxCount;
    SharedCount sharedCount;

    public SharedCounter(String name, int maxCount, SharedCount sharedCount) {
        setName(name);
        this.maxCount = maxCount;
        this.sharedCount = sharedCount;
        count = 0;
    }

    @Override
    public void run() {
        while (count < maxCount) {
            count++;
            synchronized (sharedCount) {
                sharedCount.increment();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SharedCount sharedCount = new SharedCount();
        SharedCounter counter1 = new SharedCounter("counter1", 10000, sharedCount);
        SharedCounter counter2 = new SharedCounter("counter2", 10000, sharedCount);

        counter1.start();
        counter2.start();
        System.out.println(counter1.getName() + " : started");
        System.out.println(counter2.getName() + " : started");

        counter1.join();
        counter2.join();
        System.out.println(counter1.getName() + " : terminated");
        System.out.println(counter2.getName() + " : terminated");

        System.out.println(counter1.count);
        System.out.println(counter2.count);
        System.out.println("sharedCount : " + sharedCount.getCount());
    }
}
