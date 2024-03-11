package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;

public class PaintableBox extends Box implements Paintable {

    private Color color;

    public PaintableBox(int x, int y, int width, int height, Color color) {
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
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
}
