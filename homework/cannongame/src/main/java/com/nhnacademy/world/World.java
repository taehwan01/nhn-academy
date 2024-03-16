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
    Wall floor;
    Hittable floorHittable;

    public World(int x, int y, int width, int height) {
        super();
        setBounds(x, y, width, height);
        setBackground(Color.LIGHT_GRAY);

        floor = new Wall(0, height - Constants.WALL_THICKNESS, width, Constants.WALL_THICKNESS);
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

        for (BoundaryAble object : objects) {
            if (object instanceof Paintable) {
                ((Paintable) object).paint(g);
            }
        }

        floor.paint(g);
    }
}
