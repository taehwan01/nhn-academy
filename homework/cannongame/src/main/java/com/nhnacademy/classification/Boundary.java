package com.nhnacademy.classification;

import java.awt.Rectangle;

public class Boundary {
    private final Rectangle rectangle;

    public Boundary(int x, int y, int width, int height) {
        rectangle = new Rectangle(x, y, width, height);
    }

    public int getMinX() {
        return (int) rectangle.getMinX();
    }

    public int getCenterX() {
        return (int) rectangle.getCenterX();
    }

    public int getMaxX() {
        return (int) rectangle.getMaxX();
    }

    public int getMinY() {
        return (int) rectangle.getMinY();
    }

    public int getCenterY() {
        return (int) rectangle.getCenterY();
    }

    public int getMaxY() {
        return (int) rectangle.getMaxY();
    }

    public int getWidth() {
        return (int) rectangle.getWidth();
    }

    public int getHeight() {
        return (int) rectangle.getHeight();
    }

    public boolean isCollided(Boundary other) {
        return rectangle.intersects(other.getRectangle());
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
