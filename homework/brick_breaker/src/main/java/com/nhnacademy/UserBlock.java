package com.nhnacademy;

import java.awt.Color;

public class UserBlock extends PaintableBox implements Regionable {
    private static final Color DEFAULT_COLOR = Color.BLACK;
    private static final int DEFAULT_MOVEMENT = 25;

    public UserBlock(int x, int y, int width, int height) {
        super(x, y, width, height, DEFAULT_COLOR);
    }

    public int getMovement() {
        return DEFAULT_MOVEMENT;
    }

    public void moveLeft() {
        setX(getX() - DEFAULT_MOVEMENT);
    }

    public void moveRight() {
        setX(getX() + DEFAULT_MOVEMENT);
    }
}
