package com.nhnacademy.classification;

import com.nhnacademy.vector.Vector;

public interface Movable extends Runnable {
    public int getDX();

    public void setDX(int dx);

    public int getDY();

    public void setDY(int dy);

    public Vector getVector();

    public void setVector(int dx, int dy);

    public void setVector(Vector newVector);

    public void move();

    public void move(Vector vector);

    public int getDT();

    public void setDT(int dt);

    public void stop();

    public void setMovableListener(MovableListener listener);
}