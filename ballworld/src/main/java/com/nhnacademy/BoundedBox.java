package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;

public class BoundedBox extends MoveableBox implements Bounded {
    static final int BOTTOM_INSET = 28; // JFrame의 제목 있는 부분이 28픽셀인 것인지, 아래에서 공들이 가려진다
    Rectangle boundary;

    public BoundedBox(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    public Rectangle getBoundary() {
        return boundary;
    }

    public void setBoundary(Rectangle boundary) {
        if (boundary == null) {
            throw new IllegalArgumentException();
        }

        this.boundary = boundary;
    }

    public boolean isOutOfBounds() {
        return getX() + getDX() - getWidth() / 2 < getBoundary().getMinX()
                || getX() + getDX() + getWidth() / 2 > getBoundary().getMaxX()
                || getY() + getDY() - getHeight() / 2 < getBoundary().getMinY()
                || getY() + getDY() + getHeight() / 2 > getBoundary().getMaxY();
    }

    @Override
    public void move() {
        if (isOutOfBounds()) {
            bounce();
        }
        super.move();
    }

    public void bounce() {
        if (getX() + getDX() - getWidth() / 2 < getBoundary().getMinX()
                || getX() + getDX() + getWidth() / 2 > getBoundary().getMaxX()) {
            setDX(-getDX());
        }

        if (getY() + getDY() - getHeight() / 2 < getBoundary().getMinY()
                || getY() + getDY() + getHeight() / 2 > getBoundary().getMaxY()) {
            setDY(-getDY());
        }
    }

    public void bounce(Regionable other) {
        Rectangle intersection = getRegion().intersection(other.getRegion()); // 다른 박스와 겹친 부분

        if ((getRegion().getHeight() != intersection.getHeight())
                && (other.getRegion().getHeight() != intersection.getHeight())) {
            setDY(-getDY());
        }

        if ((getRegion().getWidth() != intersection.getWidth())
                && (other.getRegion().getWidth() != intersection.getWidth())) {
            setDX(-getDX());
        }
    }
}
