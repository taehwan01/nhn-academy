package com.nhnacademy;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore se = new Semaphore(1);
        SyncMulti th1 = new SyncMulti(se, "1");
        SyncMulti th2 = new SyncMulti(se, "2");
        SyncMulti th3 = new SyncMulti(se, "3");
        SyncMulti th4 = new SyncMulti(se, "4");

        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}