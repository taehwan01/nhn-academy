package com.nhnacademy.exam07;

public class SharedCount {
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public synchronized void increment() {
        setCount(getCount() + 1);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
