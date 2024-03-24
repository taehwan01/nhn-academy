package com.nhnacademy.exam07;

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
            sharedCount.increment();
            System.out.println(sharedCount.getCount());
        }
    }
}
