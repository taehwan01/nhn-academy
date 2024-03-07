package com.nhnacademy;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Tree {
    static final int START_DEGREES = 90;
    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 800;

    public static class MyCanvas extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            drawBranch(g, FRAME_WIDTH / 2, FRAME_HEIGHT, START_DEGREES, (double) FRAME_HEIGHT / 4);
        }

        /**
         * 나뭇가지 1개 그리기
         * 
         * @param g       그래픽스 객체
         * @param startX  시작점 X좌표
         * @param startY  시작점 Y좌표
         * @param degrees 나뭇가지 각도
         * @param length  나뭇가지 길이
         * 
         *                종료 조건: 나뭇가지 길이가 3보다 작을 때
         */
        public static void drawBranch(Graphics g, int startX, int startY, int degrees, double length) {
            if (length < 3) {
                return;
            }

            int endX = startX - (int) (Math.cos(Math.toRadians(degrees)) * length);
            int endY = startY - (int) (Math.sin(Math.toRadians(degrees)) * length);

            g.drawLine(startX, startY, endX, endY);

            length = length * 0.75;

            drawBranch(g, endX, endY, degrees - 30, length);
            drawBranch(g, endX, endY, degrees + 30, length);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("T R E E");

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        MyCanvas canvas = new MyCanvas();
        frame.add(canvas);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}