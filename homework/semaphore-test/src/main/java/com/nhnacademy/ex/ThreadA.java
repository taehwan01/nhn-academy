package com.nhnacademy.ex;

import java.util.Scanner;

public class ThreadA extends Thread {
    private WorkObject workObject;

    public ThreadA(WorkObject workObject) {
        this.workObject = workObject;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        String line;
        while (!((line = sc.nextLine()).equals("q"))) {

            workObject.methodA();
        }
    }
}