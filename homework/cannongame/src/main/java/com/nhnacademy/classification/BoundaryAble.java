package com.nhnacademy.classification;

public interface BoundaryAble {
    public Boundary getBoundary();

    public String getID();

    public int getX();

    public int getY();

    public int getWidth();

    public int getHeight();

    public boolean isCollided(Boundary other);
}
