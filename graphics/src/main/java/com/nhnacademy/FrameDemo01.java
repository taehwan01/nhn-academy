package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameDemo01 {
    public static class MyCanvas extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(Color.ORANGE);
            drawBox(g, 10, 10, 5, 5);
        }

        public static void drawBox(Graphics g, int x, int y, int width, int height) {
            if (width <= 50) { // 종료 조건: 너비가 50을 넘어가면 종료
                g.drawRect(x, y, width, height);
                drawBox(g, x + 20, y + 20, width + 5, height + 5);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GraphicsDemo03");

        frame.setSize(300, 300);

        MyCanvas canvas = new MyCanvas();
        frame.add(canvas);

        frame.setVisible(true);
    }
}