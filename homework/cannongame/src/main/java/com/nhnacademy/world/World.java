package com.nhnacademy.world;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

import com.nhnacademy.classification.BoundaryAble;
import com.nhnacademy.classification.Paintable;

public class World extends JPanel {
    List<BoundaryAble> objects = new ArrayList<>();

    public World() {
        super();
    }

    public int getObjectCount() {
        return objects.size();
    }

    public void add(BoundaryAble object) {
        objects.add(object);
    }

    public void remove(BoundaryAble object) {
        objects.remove(object);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (BoundaryAble object : objects) {
            if (object instanceof Paintable) {
                ((Paintable) object).paint(g);
            }
        }
    }
}
