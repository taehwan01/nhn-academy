package com.nhnacademy;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
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
                dashboard.setLayout(new GridLayout(9, 1));
                border.add(dashboard);

                JLabel speedLabel = new JLabel("속도");
                speedLabel.setForeground(Color.LIGHT_GRAY);
                JSlider speedSlider = new JSlider(0, 1000, 501);
                speedSlider.setForeground(Color.LIGHT_GRAY);
                speedSlider.setMajorTickSpacing(200);
                speedSlider.setMinorTickSpacing(50);
                speedSlider.setPaintTicks(true);
                speedSlider.setPaintLabels(true);
                speedSlider.addChangeListener(e -> {
                        double speed = speedSlider.getValue();
                        world.setSpeed(speed);
                });
                dashboard.add(speedLabel);
                dashboard.add(speedSlider);

                JLabel angleLabel = new JLabel("각도");
                angleLabel.setForeground(Color.LIGHT_GRAY);
                JSlider angleSlider = new JSlider(0, 90, 45);
                angleSlider.setForeground(Color.LIGHT_GRAY);
                angleSlider.setMajorTickSpacing(10);
                angleSlider.setMinorTickSpacing(5);
                angleSlider.setPaintTicks(true);
                angleSlider.setPaintLabels(true);
                angleSlider.addChangeListener(e -> {
                        int angle = angleSlider.getValue();
                        world.setAngle(angle);
                });
                dashboard.add(angleLabel);
                dashboard.add(angleSlider);

                JLabel gravityLabel = new JLabel("중력");
                gravityLabel.setForeground(Color.LIGHT_GRAY);
                JSlider gravitySlider = new JSlider(0, 10, 1);
                gravitySlider.setForeground(Color.LIGHT_GRAY);
                gravitySlider.setMajorTickSpacing(2);
                gravitySlider.setPaintTicks(true);
                gravitySlider.setPaintLabels(true);
                gravitySlider.addChangeListener(e -> {
                        int gravity = gravitySlider.getValue();
                        world.setGravity(gravity);
                });
                dashboard.add(gravityLabel);
                dashboard.add(gravitySlider);

                JLabel windLabel = new JLabel("바람");
                windLabel.setForeground(Color.LIGHT_GRAY);
                JSlider windSlider = new JSlider(-10, 10, 0);
                windSlider.setForeground(Color.LIGHT_GRAY);
                windSlider.setMajorTickSpacing(2);
                windSlider.setPaintTicks(true);
                windSlider.setPaintLabels(true);
                windSlider.addChangeListener(e -> {
                        int wind = windSlider.getValue();
                        world.setWind(wind);
                });
                dashboard.add(windLabel);
                dashboard.add(windSlider);

                JPanel buttons = new JPanel();
                buttons.setLayout(new GridLayout(1, 2));

                JButton buttonFire = new JButton("F I R E !");
                buttonFire.addActionListener(e -> {
                        try {
                                world.fire();
                                // world.fire(ball);
                        } catch (IllegalAccessError ex) {
                                // alert 창 띄우기
                                JOptionPane.showMessageDialog(null, ex.getMessage(), "경고",
                                                JOptionPane.WARNING_MESSAGE);
                        }
                });
                buttonFire.setBackground(Color.DARK_GRAY);
                buttons.add(buttonFire);

                JButton buttonClear = new JButton("C L E A R !");
                buttonClear.addActionListener(e -> {
                        try {
                                world.clear();
                        } catch (IllegalAccessError ex) {
                                // alert 창 띄우기
                                JOptionPane.showMessageDialog(null, ex.getMessage(), "경고",
                                                JOptionPane.WARNING_MESSAGE);
                        }
                });
                buttonClear.setBackground(Color.LIGHT_GRAY);
                buttons.add(buttonClear);
                buttons.setBackground(Color.DARK_GRAY);
                dashboard.add(buttons);

                int worldX = Constants.DASHBOARD_WIDTH;
                int worldY = 0;
                world = new CannonWorld(worldX, worldY, Constants.WORLD_WIDTH,
                                Constants.WORLD_HEIGHT, Constants.DEFAULT_WORLD_DT);
                border.add(world);
        }

        public void start() {
                setVisible(true);
                world.run();
                // jslider
                // setWind, setGravity, setAngle
        }
}
