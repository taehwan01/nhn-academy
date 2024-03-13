package com.nhnacademy;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    private final String name;
    private final Store store;

    public Consumer(String name, Store store) {
        this.name = name;
        this.store = store;
    }

    @Override
    public void run() {
        // while (store.getPeopleCount() < Constants.MAX_PEOPLE_COUNT) {
        try {
            store.enter();
            System.out.println("* [Consumer " + name + "] 입장했습니다.");
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000));
            store.sell();
            store.exit();
            System.out.println("* [Consumer " + name + "] 퇴장했습니다.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // }
    }
}