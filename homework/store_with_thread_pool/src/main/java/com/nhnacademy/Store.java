package com.nhnacademy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Store {
    private static final int CONSUMER_CAPACITY = 20;
    private static final int PRODUCER_CAPACITY = 5;

    List<Item> items;
    // thread pool
    ExecutorService consumerPool;
    ExecutorService producerPool;
    Logger logger = LogManager.getLogger(this.getClass().getSimpleName());

    public Store() {
        items = new ArrayList<>();
        items.add(new Item(Category.FRUIT));
        items.add(new Item(Category.VEGETABLE));
        items.add(new Item(Category.MEAT));
        items.add(new Item(Category.FISH));
        items.add(new Item(Category.DAIRY));

        consumerPool = Executors.newFixedThreadPool(CONSUMER_CAPACITY);
        producerPool = Executors.newFixedThreadPool(PRODUCER_CAPACITY);
    }

    public void enter(Runnable human) {
        logger.info("* {} 입장합니다.", ((Human) human).getName());
        if (human instanceof Consumer) {
            consumerPool.execute(human);
        } else if (human instanceof Producer) {
            producerPool.execute(human);
        }
    }

    public void close() {
        consumerPool.shutdown();
        producerPool.shutdown();
    }

    public void earnSupply() {
        for (Item item : items) { // 모든 물품에 대해 생산자가 확인하며 물품 공급 시도
            item.supply();
        }
    }

    public void sell() {
        for (Item item : items) {
            if (ThreadLocalRandom.current().nextBoolean()) { // 소비자는 물건을 살 수도, 안 살 수도 있다
                item.sell();
            }
        }
    }
}
