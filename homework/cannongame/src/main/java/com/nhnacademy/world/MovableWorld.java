package com.nhnacademy.world;

import com.nhnacademy.ball.MovableBall;
import com.nhnacademy.classification.BoundaryAble;
import com.nhnacademy.classification.Movable;

public class MovableWorld extends World {
    private int dt;

    public int getDT() {
        return dt;
    }

    public void setDT(int dt) {
        this.dt = dt;
    }

    public void move() {
        for (int i = 0; i < getCount(); i++) {
            BoundaryAble object = get(i);
            if (object instanceof MovableBall) {
                ((Movable) object).move();
            }
        }
        repaint();
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            move();
            try {
                Thread.sleep(getDT());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
