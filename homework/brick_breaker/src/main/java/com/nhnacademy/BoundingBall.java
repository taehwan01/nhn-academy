package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;

public class BoundingBall extends PaintableBall implements Boundable, Moveable {
    private final Vector motion = new Vector();

    public BoundingBall(int x, int y, int radius, Color color, int dx, int dy) {
        super(x, y, radius, color);
        motion.set(dx, dy);
    }

    public int getDX() {
        return motion.getDX();
    }

    public void setDX(int dx) {
        motion.setDX(dx);
    }

    public int getDY() {
        return motion.getDY();
    }

    public void setDY(int dy) {
        motion.setDY(dy);
    }

    @Override
    public void move() {
        setX(getX() + motion.getDX());
        setY(getY() + motion.getDY());
    }

    @Override
    public void bounce(Regionable other) {
        Rectangle intersection = getRegion().intersection(other.getRegion());

        if (intersection.isEmpty()) {
            return;
        }

        if (intersection.width >= intersection.height) {
            motion.turnDY();
        }
        if (intersection.width <= intersection.height) {
            motion.turnDX();
        }

        if (other instanceof Brick) {
            ((Brick) other).hit();
        }
    }
}
