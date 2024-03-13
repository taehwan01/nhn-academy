package com.nhnacademy.exam0803;

public class RunnableCounter extends Thread {
    Thread thread;
    String name;
    int maxCount;

    public RunnableCounter(ThreadGroup group, String name, int maxCount) {
        thread = new Thread(group, this, name);
        this.maxCount = maxCount;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < maxCount) {
            count++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            System.out.println(getName() + " : " + count);
        }
    }

}
