package com.nhnacademy;

import java.awt.Color;

public class MoveableBox extends PaintableBox implements Moveable {
    public static final int DEFAULT_DX = 0;
    public static final int DEFAULT_DY = 0;

    final Vector motion = new Vector();

    public MoveableBox(int x, int y, int width, int height, Color color) {
        this(x, y, width, height, color, DEFAULT_DX, DEFAULT_DY);
    }

    public MoveableBox(int x, int y, int width, int height, Color color, int dx, int dy) {
        super(x, y, width, height, color);
        setDX(dx);
        setDY(dy);
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

    @Override
    public void move() {
        moveTo(this.getX() + this.getDX(), this.getY() + this.getDY());
        logger.trace("Ball #{}: {}, {}으로 이동", this.getID(), this.getX(), this.getY());
    }

    public void moveTo(int x, int y) {
        this.setX(x);
        this.setY(y);
    }
}
