package com.nhnacademy.wall;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.UUID;

import com.nhnacademy.classification.Boundary;
import com.nhnacademy.classification.BoundaryAble;
import com.nhnacademy.classification.Paintable;
import com.nhnacademy.point.Point;
import com.nhnacademy.classification.Hittable;

public class Wall implements Paintable, BoundaryAble, Hittable {
    final String id;
    final Boundary boundary;
    private Color color = Color.BLACK;
    Hittable hitter;

    public Wall(int x, int y, int width, int height) {
        id = UUID.randomUUID().toString();
        boundary = new Boundary(x, y, width, height);
        System.out.println(id + " : " + boundary.getX() + " " + boundary.getY() + " " + boundary.getWidth() + " "
                + boundary.getHeight());
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(getColor());
        g.drawRect(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public Boundary getBoundary() {
        return boundary;
    }

    @Override
    public Rectangle getRectangle() {
        return boundary.getRectangle();
    }

    @Override
    public String getID() {
        return id;
    }

    public Point getLocation() {
        return new Point(boundary.getX(), boundary.getY());
    }

    public void setLocation(Point point) {
        boundary.setLocation(point.getX(), point.getY());
    }

    @Override
    public int getX() {
        return boundary.getX();
    }

    @Override
    public int getY() {
        return boundary.getY();
    }

    @Override
    public int getWidth() {
        return boundary.getWidth();
    }

    @Override
    public int getHeight() {
        return boundary.getHeight();
    }

    @Override
    public boolean isCollided(BoundaryAble other) {
        return boundary.isCollided(other.getBoundary());
    }

    @Override
    public void hit(BoundaryAble other) {
        if (hitter != null) {
            hitter.hit(other);
        }
    }

    @Override
    public void setHittable(Hittable hitter) {
        this.hitter = hitter;
    }

}
