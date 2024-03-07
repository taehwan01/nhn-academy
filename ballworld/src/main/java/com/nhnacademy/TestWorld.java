package com.nhnacademy;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class TestWorld {
    static final int FRAME_WIDTH = 400;
    static final int FRAME_HEIGHT = 300;
    static final int BALL_COUNTS = 10;
    static final int MIN_RADIUS = 10;
    static final int MAX_RADIUS = 50;
    static final int MIN_DELTA = 1;
    static final int MAX_DELTA = 3;
    static final int DELTA_TIME = 10;
    static final int MAX_MOVE_COUNT = 10000;
    static final Color[] colors = { Color.ORANGE, Color.PINK };
    static Random random = new Random();

    public static void main(String[] args) {
        JFrame frame = new JFrame("B A L L   W O R L D");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        MoveableWorld world = new MoveableWorld();
        world.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        world.setBackground(Color.WHITE);
        world.setDT(DELTA_TIME);

        addBallInWorld(world);

        frame.add(world);

        world.setEnabled(true);

        frame.setVisible(true);

        world.setMaxMoveCount(MAX_MOVE_COUNT);
        world.run();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    static void addBallInWorld(World world) {
        while (world.getCount() < BALL_COUNTS) {
            try {
                BoundedBall ball = new BoundedBall(random.nextInt(FRAME_WIDTH), random.nextInt(FRAME_HEIGHT),
                        random.nextInt(MIN_RADIUS, MAX_RADIUS - MIN_RADIUS),
                        colors[random.nextInt(0, colors.length)]);

                int dx = random.nextInt(MAX_DELTA * (-1), MAX_DELTA * 2);
                int dy = random.nextInt(MAX_DELTA * (-1), MAX_DELTA * 2);

                ball.setDX(dx);
                ball.setDY(dy);

                world.add(ball);
            } catch (IllegalArgumentException ignore) {
                //
            }
        }
    }
}