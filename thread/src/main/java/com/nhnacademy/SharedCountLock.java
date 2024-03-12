package com.nhnacademy;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedCountLock {
    Lock lock = new ReentrantLock();
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment() {
        lock.lock();
        setCount(getCount() + 1);
        lock.unlock();
    }
}
