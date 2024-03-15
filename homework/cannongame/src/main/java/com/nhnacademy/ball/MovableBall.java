package com.nhnacademy.ball;

import java.awt.Color;

import com.nhnacademy.classification.Movable;
import com.nhnacademy.point.Point;
import com.nhnacademy.vector.Vector;

public class MovableBall extends PaintableBall implements Movable {
    private Vector vector;
    private int dt;
    private int dx;
    private int dy;

    public MovableBall(int x, int y, int radius, Color color, int dx, int dy) {
        this(x, y, radius, color, new Vector(dx, dy));
    }

    public MovableBall(int x, int y, int radius, Color color, Vector vector) {
        super(x, y, radius, color);
        this.vector = vector;
    }

    @Override
    public int getDX() {
        return dx;
    }

    @Override
    public void setDX(int dx) {
        this.dx = dx;
    }

    @Override
    public int getDY() {
        return dy;
    }

    @Override
    public void setDY(int dy) {
        this.dy = dy;
    }

    public void turnDX() {
        dx *= -1;
    }

    public void turnDY() {
        dy *= -1;
    }

    @Override
    public Vector getVector() {
        return vector;
    }

    @Override
    public void setVector(int dx, int dy) {
        vector = new Vector(dx, dy);
    }

    @Override
    public void setVector(Vector newVector) {
        vector = newVector;
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
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDT'");
    }

    @Override
    public int getDT() {
        return dt;
    }

    @Override
    public void setDT(int dt) {
        this.dt = dt;
    }
}
