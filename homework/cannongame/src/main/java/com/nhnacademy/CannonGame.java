package com.nhnacademy;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

import com.nhnacademy.ball.BounceableBall;
import com.nhnacademy.ball.MovableBall;
import com.nhnacademy.vector.Vector;
import com.nhnacademy.world.MovableWorld;

public class CannonGame extends JFrame {
        private MovableWorld world;

        public CannonGame() {
                setTitle("C A N N O N   G A M E");
                setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                setLayout(null);

                JPanel border = new JPanel();
                int borderWidth = Constants.DASHBOARD_WIDTH + Constants.WORLD_WIDTH;
                int borderHeight = Constants.WORLD_HEIGHT;
                int borderX = (Constants.FRAME_WIDTH - borderWidth) / 2;
                int borderY = (Constants.FRAME_HEIGHT - borderHeight) / 2;
                border.setBounds(borderX, borderY - Constants.TOP_INSET / 2, borderWidth, borderHeight);
                border.setBackground(Color.PINK);
                border.setLayout(null);

                JPanel dashboard = new JPanel();
                dashboard.setBounds(0, 0, Constants.DASHBOARD_WIDTH, Constants.WORLD_HEIGHT);
                dashboard.setBackground(Color.DARK_GRAY);
                border.add(dashboard);
                add(border);

                int worldX = Constants.DASHBOARD_WIDTH;
                int worldY = 0;
                world = new MovableWorld(worldX, worldY, Constants.WORLD_WIDTH,
                                Constants.WORLD_HEIGHT, Constants.DEFAULT_DT);
                border.add(world);

                world.add(new MovableBall(10, 20, 10, Color.ORANGE, new Vector(5, 3)));
                world.add(new BounceableBall(1000, 600, 30, Color.PINK, -5, -2));
        }

        public void start() {
                setVisible(true);
                world.run();
        }
}
