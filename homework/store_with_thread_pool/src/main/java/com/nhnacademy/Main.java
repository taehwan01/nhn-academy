package com.nhnacademy;

public class Main {
    private static final int CONSUMER_LENGTH = 10;
    private static final int PRODUCER_LENGTH = 3;

    public static void main(String[] args) {
        Store store = new Store();

        Consumer[] consumers = new Consumer[CONSUMER_LENGTH];
        for (int i = 0; i < CONSUMER_LENGTH; i++) {
            consumers[i] = new Consumer(store, "Consumer #" + (i + 1));
        }

        Producer[] prodcers = new Producer[PRODUCER_LENGTH];
        for (int i = 0; i < PRODUCER_LENGTH; i++) {
            prodcers[i] = new Producer(store, "Producer #" + (i + 1));
        }

        for (int i = 0; i < CONSUMER_LENGTH; i++) {
            store.enter(consumers[i]);
        }

        for (int i = 0; i < PRODUCER_LENGTH; i++) {
            store.enter(prodcers[i]);
        }

        // 5분 뒤에 store 영업 종료
        try {
            Thread.sleep(3000);
            store.close();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}