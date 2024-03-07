package com.nhnacademy;

import java.awt.Color;

public class MoveableBall extends PaintableBall {
    public static final int DEFAULT_DX = 0;
    public static final int DEFAULT_DY = 0;

    final Vector motion = new Vector();

    public MoveableBall(int x, int y, int radius, Color color) {
        this(x, y, radius, color, DEFAULT_DX, DEFAULT_DY);
    }

    public MoveableBall(int x, int y, int radius, Color color, int dx, int dy) {
        super(x, y, radius, color);
        motion.setDX(dx);
        motion.setDY(dy);
    }

    public int getDX() {
        return motion.getDX();
    }

    public int getDY() {
        return motion.getDY();
    }

    public void setDX(int dx) {
        motion.setDX(dx);
    }

    public void setDY(int dy) {
        motion.setDY(dy);
    }

    public Vector getMotion() {
        return motion;
    }

    public void move() {
        moveTo(this.getX() + this.getDX(), this.getY() + this.getDY());
        logger.trace("Ball #{}: {}, {}으로 이동", this.getID(), this.getX(), this.getY());
    }

    public void moveTo(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public boolean isCollided(MoveableBall otherBall) {
        return this.getRegion().intersects(otherBall.getRegion());
    }

    public boolean willCollide(MoveableBall otherBall) {
        int nextX = otherBall.getX() + otherBall.getDX();
        int nextY = otherBall.getY() + otherBall.getDY();
        return this.getRegion().contains(nextX, nextY);
    }
}
