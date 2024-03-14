package com.nhnacademy.ball;

import java.awt.Color;

import com.nhnacademy.classification.Movable;
import com.nhnacademy.point.Point;
import com.nhnacademy.vector.Vector;

public class MovableBall extends PaintableBall implements Movable {
    private Vector vector;
    private int dt;

    public MovableBall(int x, int y, int radius, Color color, Vector vector) {
        super(x, y, radius, color);
        this.vector = vector;
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
