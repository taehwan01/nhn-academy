package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;

public class PaintableBrick extends Brick implements Paintable {
    static final Color DEFAULT_COLOR = Color.BLACK;
    private Color color;

    public PaintableBrick(int x, int y, int width, int height) {
        this(x, y, width, height, DEFAULT_COLOR);
    }

    public PaintableBrick(int x, int y, int width, int height, Color color) {
        super(x, y, width, height);
        this.color = color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(getColor());
        g.drawRect(getX() - getWidth() / 2, getY() - getHeight() / 2, getWidth(), getHeight());
    }
}
