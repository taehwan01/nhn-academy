package com.nhnacademy;

import java.util.concurrent.Semaphore;

public class SyncMulti extends Thread {
    Semaphore sem;
    String msg;

    public SyncMulti(Semaphore sem, String msg) {
        super();
        this.sem = sem;
        this.msg = msg;
    }

    public void run() {
        try {
            sem.acquire(); // 실행한다.
            System.out.println(msg);
            Thread.sleep(500); // 5초간 딜레이
            sem.release(); // 끊어준다.
            // 세마포어를 실행시키고 5초 후에는 세마포어를 끊어준다.
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
