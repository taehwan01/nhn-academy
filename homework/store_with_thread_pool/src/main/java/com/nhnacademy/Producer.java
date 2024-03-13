package com.nhnacademy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Producer implements Runnable, Human {
    private Store store;
    private String name;
    Logger logger = LogManager.getLogger(this.getClass().getSimpleName());

    public Producer(Store store, String name) {
        this.store = store;
        this.name = name;
        logger.info("* [ P ] {} 입니다.", getName());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void run() {
        store.enter(this);
        store.earnSupply();
        // 그러고 퇴장
        logger.info("* [ P ] {} 퇴장합니다.", getName());
    }
}
