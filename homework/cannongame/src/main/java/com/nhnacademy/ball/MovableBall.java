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
        super(x, y, radius, color);
        this.dx = dx;
        this.dy = dy;
        this.vector = new Vector(dx, dy);
    }

    public MovableBall(int x, int y, int radius, Color color, Vector vector) {
        super(x, y, radius, color);
        this.dx = vector.getDX();
        this.dy = vector.getDY();
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
        // System.out.println("set dy to : " + dy);
        this.dy = dy;
    }

    public void turnDX() {
        setDX(-dx);
    }

    public void turnDY() {
        setDY(-dy);
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
        setVector(dx, dy);
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
