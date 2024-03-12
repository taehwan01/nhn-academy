package com.nhnacademy;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        DeadlockExample deadlock = new DeadlockExample();
        new Thread(() -> {
            try {
                deadlock.operation1();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
        new Thread(() -> {
            try {
                deadlock.operation2();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    public void operation1() throws InterruptedException {
        lock1.lock();
        System.out.println("lock1 획득, lock2 획득 대기 중");
        Thread.sleep(50);

        lock2.lock();
        System.out.println("lock2 획득");

        System.out.println("#1 operation 실행");

        lock2.unlock();
        lock1.unlock();
    }

    public void operation2() throws InterruptedException {
        lock2.lock();
        System.out.println("lock2 획득, lock1 획득 대기 중");
        Thread.sleep(50);

        lock1.lock();
        System.out.println("lock1 획득");

        System.out.println("#2 operation 획득");

        lock1.unlock();
        lock2.unlock();
    }
}