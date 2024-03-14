package com.nhnacademy.classification;

public interface BoundaryAble {
    public String getID();

    public int getMinX();

    public int getCenterX();

    public int getMaxX();

    public int getMinY();

    public int getCenterY();

    public int getMaxY();

    public int getWidth();

    public int getHeight();

    public boolean isCollided(Boundary other);
}
