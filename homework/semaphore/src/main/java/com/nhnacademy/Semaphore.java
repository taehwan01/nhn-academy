package com.nhnacademy;

public class Semaphore {
    private int permits;

    public Semaphore(int permits) {
        if (permits < 0) {
            throw new IllegalArgumentException("permits < 0");
        }
        this.permits = permits;
    }

    public synchronized void acquire() {
        while (availablePermits() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted");
            }
        }
        permits--;
    }

    public synchronized void release() {
        permits++;
        notifyAll();
    }

    public boolean tryAcquire() {
        if (permits > 0) {
            permits--;
            return true;
        }
        return false;
    }

    public int availablePermits() {
        return permits;
    }
}
