package com.nhnacademy.exam0801;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5); // 5개의 스레드를 가진 풀 생성, 스레드가 5개 이상이면 대기

        for (int i = 0; i < 10; i++) {
            executor.submit(new Worker("Worker" + i)); // Worker 객체를 생성하여 풀에 제출
        }

        executor.shutdown(); // 작업이 완료되면 풀 종료

        while (!executor.isTerminated()) // 모든 작업이 완료될 때까지 대기
            ;

        System.out.println("- f i n -");
    }
}