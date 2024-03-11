package com.nhnacademy;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {
    private static final int TOP_INSETS = 28;
    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 700;
    private static final int WALL_THICKNESS = 20;
    private static final int BRICK_GAP = 5;
    private static final int BRICK_START_X = WALL_THICKNESS + BRICK_GAP;
    private static final int BRICK_START_Y = WALL_THICKNESS * 2;
    private static final int BRICK_ROWS = 6;
    private static final int BRICK_COLS = 12;
    private static final int BRICK_WIDTH = (FRAME_WIDTH - WALL_THICKNESS * 2 - BRICK_GAP * (BRICK_COLS))
            / BRICK_COLS;
    private static final int BRICK_HEIGHT = 30;

    public static void main(String[] args) {
        JFrame frame = new JFrame("B R I C K   B R E A K E R");

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        GameWorld gameWorld = new GameWorld();

        frame.add(gameWorld);

        frame.setVisible(true);

        addWalls(gameWorld);
        addBricks(gameWorld);

        gameWorld.run();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 블록이 깨질 때까지 횟수 계산하는 것은 블록이 처리하게 해.
        // 블록이 깨지면 월드에서 리스트에서 제거하게 하는데 어떻게 해?
        // 람다로 넘겨줄 수 있음.
    }

    private static void addWalls(GameWorld gameWorld) {
        gameWorld.add(new Wall(0, 0, FRAME_WIDTH, WALL_THICKNESS));
        gameWorld.add(new Wall(0, 0, WALL_THICKNESS, FRAME_HEIGHT));
        gameWorld.add(new Wall(FRAME_WIDTH - WALL_THICKNESS, 0, WALL_THICKNESS, FRAME_HEIGHT));
    }

    private static void addBricks(GameWorld gameWorld) {
        for (int i = 0; i < BRICK_ROWS; i++) {
            for (int j = 0; j < BRICK_COLS; j++) {
                gameWorld.add(new Brick(BRICK_START_X + j * (BRICK_WIDTH + BRICK_GAP),
                        BRICK_START_Y + i * (BRICK_HEIGHT + BRICK_GAP),
                        BRICK_WIDTH, BRICK_HEIGHT, Color.BLACK, 1));
            }
        }
    }
}