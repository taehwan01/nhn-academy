package com.nhnacademy;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("B R I C K   B R E A K E R");

        frame.setSize(800, 600);

        GameWorld gameWorld = new GameWorld();

        frame.add(gameWorld);

        frame.setVisible(true);

        gameWorld.add(new PaintableBall(300, 300, 20, Color.BLACK));
        gameWorld.run();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}