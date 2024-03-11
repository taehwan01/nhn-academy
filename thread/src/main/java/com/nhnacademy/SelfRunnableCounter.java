package com.nhnacademy;

public class SelfRunnableCounter implements Runnable {
    String name;
    int maxCount;
    int count;
    Thread thread;

    public SelfRunnableCounter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
        count = 0;
        thread = new Thread(this, name);
    }

    public int getCount() {
        return count;
    }

    public Thread getThread() {
        return thread;
    }

    public boolean isAlive() {
        return getThread().isAlive();
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        thread.interrupt();
        System.out.println(thread.getName() + " stopped");
        System.out.println(Thread.currentThread().getName() + " stopped"); // main thread, 왜? stop()을 누가 불렀는가! caller가
                                                                           // 기준이다.
    }

    @Override
    public void run() {
        while (!thread.isInterrupted() && count < maxCount) { // running flag로 하면 sleep() 하고 걸림 interrupt()하면 sleep 중인
                                                              // 스레드를 바로 꺠워서 catch문으로 넘어가고, 안 자고 있으면 다음 명령문을 실행하고 종료한다.
            try {
                Thread.sleep(100);
                count++;
                System.out.println(name + " : " + count);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted"); // this.thread, 왜?
                                                                                       // this.thread가caller이기 때문.
                Thread.currentThread().interrupt();
            }
        }
        // 사라질 시점을 정해줘야한다.
    }
}
