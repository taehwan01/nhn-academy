package com.nhnacademy.classification;

import com.nhnacademy.vector.Vector;

public interface Movable {
    public Vector getMotion();

    public void setMotion(int dx, int dy);

    public void setMotion(Vector newMotion);

    public void move();

    public void move(Vector newMotion);
}