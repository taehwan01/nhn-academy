package com.nhnacademy;

public class Exam02 {
    public static void main(String[] args) {
        SelfRunnableCounter[] counters = new SelfRunnableCounter[10];

        for (int i = 0; i < counters.length; i++) {
            counters[i] = new SelfRunnableCounter("Counter" + (i + 1), 10);
            counters[i].start();
        }

        boolean allStopped = false; // 다 멈췄어?
        while (!allStopped) { // 다 멈춘게 아니면 반복문을 계속 수행한다!
            if (counters[0].getCount() > 4) { // count가 4 넘은 애는 멈춰
                for (int i = 0; i < counters.length; i++) {
                    counters[i].stop();
                }
            }

            allStopped = true; // 다 멈춘 거라 가정
            for (int i = 0; i < counters.length; i++) {
                if (counters[i].getThread().isAlive()) { // 아직 살아있는 애가 있어! 다 멈춘 게 아니야!
                    allStopped = false;
                }
            }
        }
    }
}