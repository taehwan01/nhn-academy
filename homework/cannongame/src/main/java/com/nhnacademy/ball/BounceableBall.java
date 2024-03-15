package com.nhnacademy.ball;

import java.awt.Color;

import com.nhnacademy.classification.Bounceable;
import com.nhnacademy.classification.Boundary;
import com.nhnacademy.classification.BoundaryAble;

public class BounceableBall extends MovableBall implements Bounceable {
    public BounceableBall(int x, int y, int radius, Color color, int dx, int dy, int dt) {
        super(x, y, radius, color, dx, dy, dt);
    }

    @Override
    public void bounce(BoundaryAble other) {
        if (isCollided(other)) {
            Boundary intersection = getBoundary().intersection(other.getBoundary());

            if (intersection.getWidth() > intersection.getHeight()) {
                turnDY();
            } else if (intersection.getWidth() < intersection.getHeight()) {
                turnDX();
            } else {
                turnDX();
                turnDY();
            }
        }
    }

}
