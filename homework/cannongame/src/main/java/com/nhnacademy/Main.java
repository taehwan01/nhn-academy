package com.nhnacademy;

import java.awt.Color;

import javax.swing.JFrame;

import com.nhnacademy.ball.PaintableBall;
import com.nhnacademy.world.World;

public class Main {

    public static void main(String[] args) {
        System.out.println("* TODO: 예외 처리는 까먹지 말고 다 해줘");
        JFrame frame = new JFrame("C A N N O N   G A M E");
        frame.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);

        World world = new World();
        world.add(new PaintableBall(20, 20, 10));
        world.add(new PaintableBall(40, 40, 30, Color.RED));

        frame.add(world);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}