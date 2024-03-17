package com.nhnacademy.world;

import java.awt.Color;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.nhnacademy.Constants;
import com.nhnacademy.ball.BounceableBall;
import com.nhnacademy.classification.Bounceable;
import com.nhnacademy.classification.BoundaryAble;
import com.nhnacademy.classification.Hittable;
import com.nhnacademy.classification.Movable;
import com.nhnacademy.vector.Vector;

public class CannonWorld extends MovableWorld {
    transient ExecutorService threadPool = Executors.newFixedThreadPool(Constants.THREAD_COUNT);
    private int ballCount;
    private Vector gravity = new Vector(0, 1);
    private Vector wind = new Vector(1, 0);

    public CannonWorld(int x, int y, int width, int height, int dt) {
        super(x, y, width, height, dt);
        ballCount = 0;
    }

    public void fire() {
        int radius = 10;
        BounceableBall ball = new BounceableBall(0,
                Constants.WORLD_HEIGHT - Constants.WALL_THICKNESS
                        - Constants.DEFAULT_CANNONBALL_RADIUS * 2,
                Constants.DEFAULT_CANNONBALL_RADIUS, Color.BLACK, 6, -14,
                Constants.DEFAULT_CANNONBALL_DT);

        ball.setMovableListener(() -> {
            Vector newVector = ball.getVector();
            newVector.add(gravity);
            // newVector.add(wind);

            ball.setVector(newVector);

            if (ball instanceof Bounceable) {
                for (int i = 0; i < getCount(); i++) {
                    BoundaryAble other = get(i);

                    if (ball != other && ball.isCollided(other)) {
                        ((Bounceable) ball).bounce(other);

                        if (other instanceof Hittable) {
                            ((Hittable) other).hit(ball);
                        }
                    }
                }
            }
        });

        add(ball);
    }

    @Override
    public void add(BoundaryAble object) {
        if (ballCount > Constants.THREAD_COUNT) {
            throw new IllegalAccessError("공이 너무 많습니다.");
        }
        super.add(object);
        if (object instanceof Movable) {
            threadPool.execute((Movable) object);
        }
        ballCount++;
    }
}
