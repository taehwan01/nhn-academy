package com.nhnacademy.classification;

import java.awt.Rectangle;

public interface BoundaryAble {
    public Boundary getBoundary();

    public Rectangle getRectangle();

    public String getID();

    public int getX();

    public int getY();

    public int getWidth();

    public int getHeight();

    public boolean isCollided(Boundary other);
}
