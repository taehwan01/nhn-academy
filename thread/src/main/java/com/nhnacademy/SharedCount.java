package com.nhnacademy;

public class SharedCount {
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // 보호되어야 할, 동기화되어야 할 부분에 추가(mutual exclusion) lock도 마찬가지
    // 객체 단위로 걸림
    public /* synchronized */void increment() {
        // synchronized (this) {
        setCount(getCount() + 1);
        // }
    }
}
