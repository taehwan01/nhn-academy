package com.nhnacademy;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Triangle {
    static final int[] START_X = { 0, 400, 800 };
    static final int[] START_Y = { 700, 0, 700 };
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 800;

    public static class MyCanvas extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            int shortSideLength = START_X[2] - START_X[0];
            drawTriangle(g, START_X, START_Y, shortSideLength);
        }

        /**
         * 삼각형 하나 그리고, 내부 삼각형 3개 그리는 재귀함수
         * 
         * @param g               그래픽스 객체
         * @param x               삼각형의 x 좌표들
         * @param y               삼각형의 y 좌표들
         * @param shortSideLength 가장 짧은 변의 길이
         * 
         *                        종료 조건: 가장 짧은 변의 길이가 3보다 작을 때
         */
        public static void drawTriangle(Graphics g, int[] x, int[] y, int shortSideLength) {
            if (shortSideLength < 3) {
                return;
            }

            g.drawPolygon(x, y, 3);

            int[] midX = new int[3];
            int[] midY = new int[3];
            getMidPoint(x, y, midX, midY); // 각 변의 중점을 구하기

            int[] leftTriangleX = { x[0], midX[0], midX[2] };
            int[] leftTriangleY = { y[0], midY[0], midY[2] };
            drawTriangle(g, leftTriangleX, leftTriangleY, shortSideLength / 2); // 왼쪽 아래 삼각형

            int[] rightTriangleX = { midX[0], x[1], midX[1] };
            int[] rightTriangleY = { midY[0], y[1], midY[1] };
            drawTriangle(g, rightTriangleX, rightTriangleY, shortSideLength / 2); // 오른쪽 아래 삼각형

            int[] topTriangleX = { midX[2], midX[1], x[2] };
            int[] topTriangleY = { midY[2], midY[1], y[2] };
            drawTriangle(g, topTriangleX, topTriangleY, shortSideLength / 2); // 위 삼각형
        }
    }

    /**
     * 각 변의 중점을 구하는 함수
     * 
     * @param x    이미 그려진 삼각형의 x 좌표들
     * @param y    이미 그려진 삼각형의 y 좌표들
     * @param midX 각 변의 중점 x 좌표들
     * @param midY 각 변의 중점 y 좌표들
     */
    public static void getMidPoint(int[] x, int[] y, int[] midX, int[] midY) {
        midX[0] = (x[0] + x[1]) / 2;
        midY[0] = (y[0] + y[1]) / 2;

        midX[1] = (x[1] + x[2]) / 2;
        midY[1] = (y[1] + y[2]) / 2;

        midX[2] = (x[2] + x[0]) / 2;
        midY[2] = (y[2] + y[0]) / 2;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("T R I A N G L E");

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        MyCanvas canvas = new MyCanvas();
        frame.add(canvas);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}