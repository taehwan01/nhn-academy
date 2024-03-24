package com.nhnacademy.ex1;

public class Ex2 {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.start();
        String input = new java.util.Scanner(System.in).nextLine();
        System.out.println("INPUT: " + input);
        thread1.interrupt();
        System.out.println("isInterrupted: " + thread1.isInterrupted());
    }
}

class Thread1 extends Thread {
    public void run() {
        int i = 10;
        while (i > 0 && !isInterrupted()) {
            System.out.println("Thread1: " + i);
            i--;
            // for (long j = 0; j < 1000000000; j++) {
            // do nothing
            // Thread.sleep() 하면 interrupt()가 sleep에서 발생하므로 InterruptedException이 발생한다.
            // }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }
}