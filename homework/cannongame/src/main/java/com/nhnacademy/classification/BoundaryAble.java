package com.nhnacademy.classification;

import java.awt.Rectangle;

import com.nhnacademy.point.Point;

public interface BoundaryAble {
    public Boundary getBoundary();

    public Rectangle getRectangle();

    public String getID();

    public Point getLocation();

    public void setLocation(Point point);

    public int getX();

    public int getY();

    public int getWidth();

    public int getHeight();

    public boolean isCollided(BoundaryAble other);

    public void hit(BoundaryAble other);

    public void setHittable(Hittable listener);
}
