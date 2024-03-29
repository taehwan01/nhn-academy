package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;

public class PaintableBox extends Box implements Paintable {
    static final Color DEFAULT_COLOR = Color.BLACK;
    Color color;

    public PaintableBox(int x, int y, int width, int height) {
        this(x, y, width, height, DEFAULT_COLOR);
    }

    public PaintableBox(int x, int y, int width, int height, Color color) {
        super(x, y, width, height);

        if (color == null) {
            throw new IllegalArgumentException();
        }

        this.color = color;
    }

    @Override
    public void setColor(Color color) {
        if (color == null) {
            throw new IllegalArgumentException();
        }

        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void paint(Graphics g) {
        if (g == null) {
            throw new IllegalArgumentException();
        }

        Color originalColor = g.getColor();

        g.setColor(getColor());
        g.fillRect((int) getRegion().getX(), (int) getRegion().getY(), (int) getRegion().getWidth(),
                (int) getRegion().getHeight());

        g.setColor(originalColor);
    }

}
