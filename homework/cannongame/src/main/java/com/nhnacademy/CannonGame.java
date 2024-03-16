package com.nhnacademy;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.nhnacademy.world.CannonWorld;

public class CannonGame extends JFrame {
        private CannonWorld world;

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
                add(border);

                JPanel dashboard = new JPanel();
                dashboard.setBounds(0, 0, Constants.DASHBOARD_WIDTH, Constants.WORLD_HEIGHT);
                dashboard.setBackground(Color.DARK_GRAY);
                border.add(dashboard);

                JButton button = new JButton("F I R E");
                button.addActionListener(e -> {
                        System.out.println("F I R E 🔥");
                        try {
                                world.fire();
                        } catch (IllegalAccessError ex) {
                                // alert 창 띄우기
                                JOptionPane.showMessageDialog(null, ex.getMessage(), "경고",
                                                JOptionPane.WARNING_MESSAGE);
                        }
                });
                dashboard.add(button);

                int worldX = Constants.DASHBOARD_WIDTH;
                int worldY = 0;
                world = new CannonWorld(worldX, worldY, Constants.WORLD_WIDTH,
                                Constants.WORLD_HEIGHT, Constants.DEFAULT_WORLD_DT);
                border.add(world);
        }

        public void start() {
                setVisible(true);
                world.run();
        }
}
