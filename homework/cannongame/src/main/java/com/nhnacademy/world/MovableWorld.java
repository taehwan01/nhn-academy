package com.nhnacademy.world;

import com.nhnacademy.ball.MovableBall;
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
                System.out.println("FLOOR BOUNCE!");
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
        for (int i = 0; i < getCount(); i++) {
            BoundaryAble object = get(i);

            if (object instanceof Bounceable) {
                ((Movable) object).move();

                for (int j = 0; j < getCount(); j++) {
                    BoundaryAble other = get(j);

                    if (i != j && object.isCollided(other)) {
                        ((Bounceable) object).bounce(other);
                    }
                }
            }
        }
        repaint();
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            move();
            try {
                Thread.sleep(getDT()); // TODO: 이걸 나중에 공에다 적용해서 각자 속도 다르게 해보기
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
