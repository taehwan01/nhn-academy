package com.nhnacademy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Store {
    private static final int STORE_CAPACITY = 5;

    List<Item> items = new ArrayList<>();
    // thread pool
    ExecutorService executor;
    Logger logger = LogManager.getLogger(this.getClass().getSimpleName());

    public Store() {
        items.add(new Item(Category.FRUIT));
        items.add(new Item(Category.VEGETABLE));
        items.add(new Item(Category.MEAT));
        items.add(new Item(Category.FISH));
        items.add(new Item(Category.DAIRY));
        executor = Executors.newFixedThreadPool(STORE_CAPACITY);
    }

    public void enter(Runnable human) {
        if (human instanceof Human) {
            logger.info("* {} 입장합니다.", ((Human) human).getName());
            executor.execute(human);
        }
    }

    public void close() {
        executor.shutdown();
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
