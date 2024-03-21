package com.nhnacademy.ex;

public class WorkObject {
    public synchronized void methodA() { // 동기화 메소드에서만 사용 가능 (synchronized)

        System.out.println("AAAAAAA 작업 실행");
        notify(); // wait() 상태 스레드를 실행 대기로 변경 (실행 가능한 상태)
        try {
            wait();
        } // 자기 자신 일시정지 상태로 변경
        catch (InterruptedException e) {
        }
    }

    public synchronized void methodB() { // 동기화 메소드에서만 사용 가능 (synchronized)

        System.out.println("BBBBBBB 작업 실행");
        notify(); // wait() 상태 스레드를 실행 대기로 변경 (실행 가능한 상태)
        try {
            wait();
        } // 자기 자신 일시정지 상태로 변경
        catch (InterruptedException e) {
        }
    }
}