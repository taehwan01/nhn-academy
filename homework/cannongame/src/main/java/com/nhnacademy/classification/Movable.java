package com.nhnacademy.classification;

import com.nhnacademy.vector.Vector;

public interface Movable {
    public Vector getVector();

    public void setVector(int dx, int dy);

    public void setVector(Vector newVector);

    public void move();

    public void move(Vector newVector);

    public void stop();

    public int getDT();

    public void setDT(int dt);
}