package com.nhnacademy;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class GameWorld extends JPanel {
    List<Regionable> regionableList = new LinkedList<>();
    private int dt = 20;

    public GameWorld() {
        super();
    }

    public int getCount() {
        return regionableList.size();
    }

    public Regionable get(int index) {
        return regionableList.get(index);
    }

    public int getDT() {
        return dt;
    }

    public void setDT(int dt) {
        this.dt = dt;
    }

    public void add(Regionable obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }

        regionableList.add(obj);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Regionable obj : regionableList) {
            if (obj instanceof Paintable) {
                ((Paintable) obj).paint(g);
            }
        }
    }

    public void move() {
        for (int i = 0; i < getCount(); i++) {
            Regionable obj = get(i);
            if (obj instanceof Boundable) {
                ((Boundable) obj).move();
                for (int j = 0; j < getCount(); j++) {
                    Regionable other = get(j);
                    if (obj != other && other instanceof Boundable) {
                        ((Boundable) obj).bounce(other);
                    }
                }
            }
        }
        repaint();
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            move();
            try {
                Thread.sleep(getDT());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
