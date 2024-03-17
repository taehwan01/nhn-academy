package com.nhnacademy.ball;

import java.awt.Color;

import com.nhnacademy.classification.Bounceable;
import com.nhnacademy.classification.Boundary;
import com.nhnacademy.classification.BoundaryAble;
import com.nhnacademy.point.Point;

public class BounceableBall extends MovableBall implements Bounceable {
    public BounceableBall(int x, int y, int radius, Color color, int dx, int dy, int dt) {
        super(x, y, radius, color, dx, dy, dt);
    }

    @Override
    public void bounce(BoundaryAble other) {
        if (isCollided(other)) {
            Boundary intersection = getBoundary().intersection(other.getBoundary());

            if ((getBoundary().getHeight() != intersection.getHeight())
                    && (other.getHeight() != intersection.getHeight())) {
                if (getY() < other.getY()) {
                    setLocation(new Point(getX(), other.getY() - getRadius() * 2));
                } else {
                    setLocation(new Point(getX(), other.getY() + getRadius() * 2));
                }
                turnDY();
            }

            if ((getBoundary().getWidth() != intersection.getWidth())
                    && (other.getWidth() != intersection.getWidth())) {

                if (getX() < other.getX()) {
                    setLocation(new Point(other.getX() - getRadius() * 2, getY()));
                } else {
                    setLocation(new Point(other.getX() + getRadius() * 2, getY()));
                }
                turnDX();
            }
        }
    }

}
