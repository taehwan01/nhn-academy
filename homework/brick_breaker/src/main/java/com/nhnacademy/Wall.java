package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;

public class Wall extends PaintableBox {
    private static final Color WALL_COLOR = Color.BLACK;

    public Wall(int x, int y, int width, int height) {
        super(x, y, width, height, WALL_COLOR);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(WALL_COLOR);
        g.drawRect(getX(), getY(), getWidth(), getHeight());
    }
}
