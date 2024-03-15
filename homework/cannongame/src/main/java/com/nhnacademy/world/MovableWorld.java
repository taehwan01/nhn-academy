package com.nhnacademy.world;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.nhnacademy.classification.Bounceable;
import com.nhnacademy.classification.BoundaryAble;
import com.nhnacademy.classification.Hittable;
import com.nhnacademy.classification.Movable;
import com.nhnacademy.vector.Vector;

public class MovableWorld extends World {
    private int dt;

    public MovableWorld(int x, int y, int width, int height, int dt) {
        super(x, y, width, height);
        this.dt = dt;

        setFloorHittable(other -> {
            if (other instanceof Bounceable) {
                Vector vector = ((Movable) other).getVector();
                vector.multiply(0.7);
                ((Movable) other).setVector(vector);
            }
        });
    }

    public int getDT() {
        return dt;
    }

    public void setDT(int dt) {
        this.dt = dt;
    }

    public void move() {
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
