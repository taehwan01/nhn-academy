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
    private double speed = 1;
    private int angle = 45;
    private Vector gravity = new Vector(0, 1);
    private Vector wind = new Vector(0, 0);
    private Vector ballVector;

    public CannonWorld(int x, int y, int width, int height, int dt) {
        super(x, y, width, height, dt);
        ballCount = 0;
    }

    public void fire() {
        BounceableBall ball = new BounceableBall(0,
                Constants.WORLD_HEIGHT - Constants.WALL_THICKNESS
                        - Constants.DEFAULT_CANNONBALL_RADIUS * 2,
                Constants.DEFAULT_CANNONBALL_RADIUS, Color.BLACK, 6, -14,
                Constants.DEFAULT_CANNONBALL_DT);
        ballVector = ball.getVector();
        ballVector.multiply(speed);
        ball.setVector(ballVector);
        ball.setVector(calcAngleVector(ballVector, angle));

        ball.setMovableListener(() -> {
            Vector newVector = ball.getVector();
            newVector.add(gravity);
            newVector.add(wind);

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
            ballCount++;
        }
    }

    public void clear() {
        for (int i = 0; i < getCount(); i++) {
            BoundaryAble object = get(i);
            if (object instanceof Movable) {
                remove(object);
            }
        }
        if (threadPool != null) {
            threadPool.shutdownNow();
            threadPool = Executors.newFixedThreadPool(Constants.THREAD_COUNT);
        }
        ballCount = 0;
    }

    public void setSpeed(double speed) {
        this.speed = speed / 500;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public Vector calcAngleVector(Vector ballVector, int angle) {
        double radian = Math.toRadians(angle);
        double dx = ballVector.getDX() * Math.cos(radian);
        double dy = ballVector.getDY() * Math.sin(radian);
        return new Vector((int) dx, (int) dy);
    }

    public void setGravity(int gravity) {
        this.gravity.setDY(gravity);
    }

    public void setWind(int wind) {
        this.wind = new Vector(wind, 0);
    }

}
