package com.nhnacademy;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println("***** [PRODUCER] 물건을 채우기 시작합니다. (time: " + LocalTime.now() + ")");
        while (store.getPeopleCount() > Constants.MIN_PEOPLE_COUNT) {
            try {
                int time = ThreadLocalRandom.current().nextInt(1000, 10000);
                Thread.sleep(time);
                store.buy();
                System.out.println(
                        "* * * * * [PRODUCER] 물건을 채웠습니다. (time: " + ((double) time / 1000) + "s)");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted");
            }
        }
    }
}
