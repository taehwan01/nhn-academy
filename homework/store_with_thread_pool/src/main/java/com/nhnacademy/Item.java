package com.nhnacademy;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Item {
    private static final int MIN_COUNT = 0;
    private static final int MAX_COUNT = 10;
    private static final int WAITING_TIME = 5000; // 5초까지 기다려볼게

    private Category category;
    private int count;
    private Semaphore semaphore;
    private Logger logger = Logger.getLogger(Item.class.getName());

    public Item(Category category) {
        this.category = category;
        this.count = MAX_COUNT;
        semaphore = new Semaphore(1);
    }

    String getCategory() {
        return category.toString();
    }

    int getCount() {
        return count;
    }

    void setCount(int count) {
        this.count = count;
    }

    public void sell() {
        try {
            if (semaphore.tryAcquire(WAITING_TIME, TimeUnit.MILLISECONDS)) {
                // 세마포어를 획득한 경우
                if (getCount() > MIN_COUNT) {
                    setCount(getCount() - 1);
                    logger.info("* 구매 상품: " + getCategory() + ", 남은 개수: " + getCount());
                } else {
                    logger.info("* 구매 상품: " + getCategory() + " 의 재고가 부족합니다. 재고 충전을 기다립니다...");
                }
            } else {
                // 세마포어를 획득하지 못한 경우
                logger.warning("* TIME OUT: 세마포어를 획득하지 못했습니다.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.warning("* [E] Thread interrupted");
        } finally {
            semaphore.release();
        }
    }

    public void supply() {
        try {
            if (semaphore.tryAcquire(WAITING_TIME, TimeUnit.MILLISECONDS)) {
                if (getCount() < MAX_COUNT) {
                    setCount(getCount() + 1);
                    logger.info("* 납품 상품: " + getCategory() + ", 남은 개수: " + getCount());
                } else {
                    logger.info("* 납품 상품: " + getCategory() + " 은 이미 충분합니다. 일단 기다려봅니다...");
                }
            } else {
                logger.warning("* TIME OUT 재고는 충분합니다.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.warning("* [E] Thread interrupted");
        } finally {
            semaphore.release();
        }
    }
}