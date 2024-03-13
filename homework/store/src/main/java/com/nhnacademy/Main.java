package com.nhnacademy;

public class Main {
    static final int CONSUMER_COUNT = 15;

    public static void main(String[] args) {
        Consumer[] consumers = new Consumer[CONSUMER_COUNT];
        Thread[] consumerThreads = new Thread[CONSUMER_COUNT];

        Store store = new Store();
        Producer producer = new Producer(store);
        Thread producerThread = new Thread(producer);

        producerThread.start();
        for (int i = 0; i < CONSUMER_COUNT; i++) {
            consumers[i] = new Consumer("손님" + (i + 1), store);
            consumerThreads[i] = new Thread(consumers[i]);
            consumerThreads[i].start();
        }
    }
}