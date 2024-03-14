package com.nhnacademy.classification;

import java.awt.Color;
import java.awt.Graphics;

public interface Paintable {
    public Color getColor();

    public void setColor(Color color);

    public void paint(Graphics g);
}
