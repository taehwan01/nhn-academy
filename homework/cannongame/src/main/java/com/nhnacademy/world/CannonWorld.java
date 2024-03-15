package com.nhnacademy.world;

import java.awt.Color;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.nhnacademy.ball.BounceableBall;
import com.nhnacademy.classification.Bounceable;
import com.nhnacademy.classification.BoundaryAble;
import com.nhnacademy.classification.Hittable;
import com.nhnacademy.classification.Movable;
import com.nhnacademy.vector.Vector;

public class CannonWorld extends MovableWorld {
    transient ExecutorService threadPool = Executors.newFixedThreadPool(5);
    private int ballCount;
    private Vector gravity = new Vector(0, 1);
    private Vector wind = new Vector(0, 0);

    public CannonWorld(int x, int y, int width, int height, int dt) {
        super(x, y, width, height, dt);
        ballCount = 0;
    }

    public void fire() {
        BounceableBall ball = new BounceableBall(100, 120, 30, Color.BLACK, 4, 3, 50);

        ball.setMovableListener(() -> {
            Vector newVector = ball.getVector();
            newVector.add(gravity);
            ball.setVector(newVector);
            System.out.println(ball.getVector().getDX() + " : " + ball.getVector().getDY());

            if (ball instanceof Bounceable) {
                for (int i = 0; i < getCount(); i++) {
                    BoundaryAble other = get(i);

                    if (ball != other && ball.isCollided(other)) {
                        ((Bounceable) ball).bounce(other);

                        if (other instanceof Hittable) {
                            ((Hittable) other).hit(ball);
                            System.out.println(ball.getVector().getDX() + " : " + ball.getVector().getDY());
                        }
                    }
                }
            }
        });

        add(ball);
    }

    @Override
    public void add(BoundaryAble object) {
        if (ballCount >= 5) {
            throw new IllegalAccessError("공이 너무 많습니다.");
        }
        super.add(object);
        if (object instanceof Movable) {
            threadPool.execute((Movable) object);
        }
        ballCount++;
    }
}
