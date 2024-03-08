package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;

public class BoundedBall extends MoveableBall implements Bounded {
    static final int BOTTOM_INSET = 28; // JFrame의 제목 있는 부분이 28픽셀인 것인지, 아래에서 공들이 가려진다
    Rectangle boundary;

    public BoundedBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }

    public Rectangle getBoundary() {
        return boundary;
    }

    @Override
    public void setBoundary(Rectangle boundary) {
        if (boundary == null) {
            throw new IllegalArgumentException();
        }

        this.boundary = boundary;
    }

    public boolean isOutOfBounds() {
        return this.getX() + this.getDX() - this.getRadius() < this.getBoundary().getMinX()
                || this.getX() + this.getDX() + this.getRadius() > this.getBoundary().getMaxX()
                || this.getY() + this.getDY() - this.getRadius() < this.getBoundary().getMinY()
                || this.getY() + this.getDY() + this.getRadius() > this.getBoundary().getMaxY()
                        - BOTTOM_INSET;
    }

    @Override
    public void move() {
        if (isOutOfBounds()) {
            bounce();
        }
        super.move();
    }

    public void bounce() {
        if (this.getX() + this.getDX() - this.getRadius() < this.getBoundary().getMinX()
                || this.getX() + this.getDX() + this.getRadius() > this.getBoundary().getMaxX()) {
            this.setDX(this.getDX() * (-1));
        }

        if (this.getY() + this.getDY() - this.getRadius() < this.getBoundary().getMinY()
                || this.getY() + this.getDY() + this.getRadius() > this.getBoundary().getMaxY() - BOTTOM_INSET) {
            this.setDY(this.getDY() * (-1));
        }
    }

    public void bounce(Regionable other) {
        Rectangle intersection = getRegion().intersection(other.getRegion());

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
