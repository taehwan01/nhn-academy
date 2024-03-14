package com.nhnacademy.ball;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nhnacademy.classification.Boundary;
import com.nhnacademy.classification.BoundaryAble;

public class Ball implements BoundaryAble {
    final Logger logger = LogManager.getLogger(this.getClass().getSimpleName());
    final String id;
    final Boundary boundary;

    public Ball(int x, int y, int radius) {
        id = UUID.randomUUID().toString();
        boundary = new Boundary(x - radius, y - radius, radius * 2, radius * 2);
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public int getMinX() {
        return boundary.getMinX();
    }

    @Override
    public int getCenterX() {
        return boundary.getCenterX();
    }

    @Override
    public int getMaxX() {
        return boundary.getMaxX();
    }

    @Override
    public int getMinY() {
        return boundary.getMinY();
    }

    @Override
    public int getCenterY() {
        return boundary.getCenterY();
    }

    @Override
    public int getMaxY() {
        return boundary.getMaxY();
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
