package com.nhnacademy.world;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

import com.nhnacademy.Constants;
import com.nhnacademy.classification.BoundaryAble;
import com.nhnacademy.classification.Paintable;
import com.nhnacademy.wall.Wall;
import com.nhnacademy.classification.Hittable;

public class World extends JPanel {
    List<BoundaryAble> objects = new ArrayList<>();
    List<Wall> walls = new ArrayList<>();
    Wall floor;
    Hittable floorHittable;

    public World(int x, int y, int width, int height) {
        super();
        setBounds(x, y, width, height);
        setBackground(Color.LIGHT_GRAY);

        walls.add(new Wall(0, 0, width, Constants.WALL_THICKNESS));
        walls.add(new Wall(0, 0, Constants.WALL_THICKNESS, height));
        walls.add(new Wall(width - Constants.WALL_THICKNESS, 0, Constants.WALL_THICKNESS, height));
        floor = new Wall(0, height - Constants.WALL_THICKNESS, width, Constants.WALL_THICKNESS);
        walls.add(floor);
        objects.add(floor);
    }

    public int getCount() {
        return objects.size();
    }

    public BoundaryAble get(int i) {
        return objects.get(i);
    }

    public void add(BoundaryAble object) {
        objects.add(object);
    }

    public void remove(BoundaryAble object) {
        objects.remove(object);
    }

    public void setFloorHittable(Hittable hitter) {
        floor.setHittable(hitter);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int width = getWidth();
        int height = getHeight();
        for (int i = 1; i < 10; i++) {
            g.setColor(Color.DARK_GRAY);
            g.drawLine(0, height - i * 2, width, height - i * 2);
        }

        for (BoundaryAble object : objects) {
            if (object instanceof Paintable) {
                ((Paintable) object).paint(g);
            }
        }

        for (Wall wall : walls) {
            wall.paint(g);
        }
    }
}
