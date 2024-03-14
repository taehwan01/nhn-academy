package com.nhnacademy;

import java.awt.Color;

import javax.swing.JFrame;

import com.nhnacademy.ball.MovableBall;
import com.nhnacademy.ball.PaintableBall;
import com.nhnacademy.vector.Vector;
import com.nhnacademy.world.MovableWorld;
import com.nhnacademy.world.World;

public class Main {

    public static void main(String[] args) {
        System.out.println("* TODO: 예외 처리는 까먹지 말고 다 해줘");
        JFrame frame = new JFrame("C A N N O N   G A M E");
        frame.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);

        MovableWorld world = new MovableWorld();
        frame.add(world);
        world.add(new MovableBall(10, 20, 10, Color.ORANGE, new Vector(5, 3)));
        frame.setVisible(true);

        world.setDT(Constants.DEFAULT_DT);
        world.run();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}