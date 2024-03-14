package com.nhnacademy.classification;

import java.awt.Rectangle;

import com.nhnacademy.point.Point;
import com.nhnacademy.vector.Vector;

public class Boundary {
    private final Rectangle rectangle;

    public Boundary(int x, int y, int width, int height) {
        rectangle = new Rectangle(x, y, width, height);
    }

    public Point getLocation() {
        return new Point((int) rectangle.getX(), (int) rectangle.getY());
    }

    public void setLocation(int x, int y) {
        rectangle.setLocation(x, y);
    }

    public int getX() {
        return (int) rectangle.getX();
    }

    public int getY() {
        return (int) rectangle.getY();
    }

    public int getWidth() {
        return (int) rectangle.getWidth();
    }

    public int getHeight() {
        return (int) rectangle.getHeight();
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public boolean isCollided(Boundary other) {
        return rectangle.intersects(other.getRectangle());
    }

}
