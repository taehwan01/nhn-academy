package com.nhnacademy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LivelockExample {
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        LivelockExample livelock = new LivelockExample();

        /*
         * #20 라인은 다음과 같은 의미이다.
         * new Thread(() -> {
         * livelock.operation1();
         * }, "T2").start();
         */
        new Thread(livelock::operation1, "T2").start();
        new Thread(livelock::operation2, "T2").start();
    }

    public void operation1() {
        try {
            while (true) {
                lock1.tryLock(50, TimeUnit.MILLISECONDS);
                System.out.println("lock1 획득, lock2 획득 시도");
                Thread.sleep(50);

                if (lock2.tryLock()) {
                    System.out.println("lock2 획득");
                } else {
                    System.out.println("lock2 획득 실패, lock1 해제");
                    lock1.unlock();
                    continue;
                }

                System.out.println("#1 operation 수행");
                break;
            }
            lock2.unlock();
            lock1.unlock();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void operation2() {
        try {
            while (true) {
                lock2.tryLock(50, TimeUnit.MILLISECONDS);
                System.out.println("lock2 획득, lock1 획득 시도");
                Thread.sleep(50);

                if (lock1.tryLock()) {
                    System.out.println("lock1 획득");
                } else {
                    System.out.println("lock1 획득 실패, lock2 해제");
                    lock2.unlock();
                    continue;
                }

                System.out.println("#2 operation 수행");
                break;
            }
            lock1.unlock();
            lock2.unlock();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
