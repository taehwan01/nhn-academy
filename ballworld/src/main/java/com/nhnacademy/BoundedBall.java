package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;

public class BoundedBall extends MoveableBall {
    static final int BOTTOM_INSET = 28; // JFrame의 제목 있는 부분이 28픽셀인 것인지, 아래에서 공들이 가려진다
    Rectangle bounds;

    public BoundedBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        if (bounds == null) {
            throw new IllegalArgumentException();
        }

        this.bounds = bounds;
    }

    public boolean isOutOfBounds() {
        /*
         * return this.getX() + this.getDX() - this.getRadius() <
         * this.getBounds().getMinX()
         * || this.getX() + this.getDX() + this.getRadius() > this.getBounds().getMaxX()
         * || this.getY() + this.getDY() - this.getRadius() < this.getBounds().getMinY()
         * || this.getY() + this.getDY() + this.getRadius() > this.getBounds().getMaxY()
         * - BOTTOM_INSET;
         */
        Rectangle region = new Rectangle(getX() - getRadius(), getY() - getRadius(), getRadius() * 2, getRadius() * 2);
        Rectangle intersection = bounds.intersection(region);

        return (intersection.getWidth() != region.getWidth() || intersection.getHeight() != region.getHeight());
    }

    @Override
    public void move() {
        bounce();
        super.move();
    }

    public void bounce() {
        if (this.getX() + this.getDX() - this.getRadius() < this.getBounds().getMinX()
                || this.getX() + this.getDX() + this.getRadius() > this.getBounds().getMaxX()) {
            this.setDX(this.getDX() * (-1));
        }

        if (this.getY() + this.getDY() - this.getRadius() < this.getBounds().getMinY()
                || this.getY() + this.getDY() + this.getRadius() > this.getBounds().getMaxY() - BOTTOM_INSET) {
            this.setDY(this.getDY() * (-1));
        }
    }

    public void bounce(BoundedBall other) {
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
