package com.nhnacademy;

public class Store {
    private int peopleCount; // 매장 내 인원 수 (공유 자원)
    private int productCount; // 매장 내 물건 수 (공유 자원)

    public Store() {
        this.peopleCount = Constants.MIN_PEOPLE_COUNT; // 아무도 없음
        this.productCount = Constants.MAX_PRODUCT_COUNT; // 꽉 차 있음
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public int getProductCount() {
        return productCount;
    }

    public void enter() {
        synchronized (this) {
            while (peopleCount == Constants.MAX_PEOPLE_COUNT) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread interrupted");
                }
            }
            peopleCount++;
            System.out.println("* [STORE] 현재 총 " + peopleCount + "명 있습니다.");
            notifyAll();
        }
    }

    public void exit() {
        synchronized (this) {
            while (peopleCount == Constants.MIN_PEOPLE_COUNT) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread interrupted");
                }
            }
            peopleCount--;
            System.out.println("* [STORE] 현재 총 " + peopleCount + "명 있습니다.");
            notifyAll();
        }
    }

    public synchronized void buy() {
        while (productCount == Constants.MAX_PRODUCT_COUNT) { // 10
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted");
            }
        }
        System.out.println("* [STORE] 물건을 채웠습니다. (" + productCount + "개 남음)");
        productCount++;
        notifyAll();
    }

    public synchronized void sell() {
        while (productCount <= Constants.MIN_PRODUCT_COUNT) { // 0
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted");
            }
        }
        System.out.println("* [STORE] 물건을 팔았습니다. (" + productCount + "개 남음)");
        productCount--;
        notifyAll();
    }
}
