package com.nhnacademy.ball;

import java.awt.Color;

import com.nhnacademy.classification.Movable;
import com.nhnacademy.classification.MovableListener;
import com.nhnacademy.point.Point;
import com.nhnacademy.vector.Vector;

public class MovableBall extends PaintableBall implements Movable {
    private int dt;
    private Vector vector;
    private Thread thread;
    private boolean isRunning;
    private MovableListener movableListener;

    public MovableBall(int x, int y, int radius, Color color, int dx, int dy, int dt) {
        this(x, y, radius, color, new Vector(dx, dy), dt);
    }

    public MovableBall(int x, int y, int radius, Color color, Vector vector, int dt) {
        super(x, y, radius, color);
        this.vector = new Vector(vector); // 복사 생성자를 사용한 이유는 vector를 변경하면 안되기 때문
        this.dt = dt;
    }

    @Override
    public int getDX() {
        return vector.getDX();
    }

    @Override
    public void setDX(int dx) {
        vector.setDX(dx);
    }

    @Override
    public int getDY() {
        return vector.getDY();
    }

    @Override
    public void setDY(int dy) {
        vector.setDY(dy);
    }

    public void turnDX() {
        vector.setDX(-getDX());
    }

    public void turnDY() {
        vector.setDY(-getDY());
    }

    @Override
    public Vector getVector() {
        return new Vector(vector);
    }

    @Override
    public void setVector(int dx, int dy) {
        setDX(dx);
        setDY(dy);
    }

    @Override
    public void setVector(Vector other) {
        setDX(other.getDX());
        setDY(other.getDY());
    }

    @Override
    public void move() {
        move(vector);
    }

    @Override
    public void move(Vector vector) {
        Point currentPoint = getLocation();
        currentPoint.translate(vector);
        setLocation(currentPoint);

        if (movableListener != null) {
            movableListener.action();
        }
    }

    @Override
    public int getDT() {
        return dt;
    }

    @Override
    public void setDT(int dt) {
        this.dt = dt;
    }

    @Override
    public void run() {
        thread = Thread.currentThread();
        isRunning = true;
        while (isRunning) {
            try {
                move();
                Thread.sleep(getDT());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void stop() {
        isRunning = false;
        if (thread != null) {
            thread.interrupt();
        }
    }

    @Override
    public void setMovableListener(MovableListener listener) {
        this.movableListener = listener;
    }
}
