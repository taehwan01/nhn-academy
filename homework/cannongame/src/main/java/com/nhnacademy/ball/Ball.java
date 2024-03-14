package com.nhnacademy.ball;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nhnacademy.classification.Boundary;
import com.nhnacademy.classification.BoundaryAble;
import com.nhnacademy.point.Point;

public class Ball implements BoundaryAble {
    final Logger logger = LogManager.getLogger(this.getClass().getSimpleName());
    final String id;
    final Boundary boundary;

    public Ball(int x, int y, int radius) {
        id = UUID.randomUUID().toString();
        boundary = new Boundary(x, y, radius * 2, radius * 2);
    }

    @Override
    public Boundary getBoundary() {
        return boundary;
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
    public boolean isCollided(Boundary other) {
        return boundary.isCollided(other);
    }
}
