package com.nhnacademy.ball;

import java.awt.Rectangle;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nhnacademy.classification.Boundary;
import com.nhnacademy.classification.BoundaryAble;
import com.nhnacademy.classification.Hittable;
import com.nhnacademy.point.Point;

public class Ball implements BoundaryAble, Hittable {
    private int radius;
    final Logger logger = LogManager.getLogger(this.getClass().getSimpleName());
    final String id;
    final Boundary boundary;
    Hittable hitter;

    public Ball(int x, int y, int radius) {
        id = UUID.randomUUID().toString();
        this.radius = radius;
        boundary = new Boundary(x, y, radius * 2, radius * 2);
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
    public boolean isCollided(BoundaryAble other) {
        return boundary.isCollided(other.getBoundary());
    }

    @Override
    public int getWidth() {
        return boundary.getWidth();
    }

    @Override
    public int getHeight() {
        return boundary.getHeight();
    }

    public int getRadius() {
        return radius;
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
