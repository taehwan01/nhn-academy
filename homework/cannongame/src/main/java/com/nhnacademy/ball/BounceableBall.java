package com.nhnacademy.ball;

import java.awt.Color;

import com.nhnacademy.classification.Bounceable;
import com.nhnacademy.classification.Boundary;
import com.nhnacademy.vector.Vector;

public class BounceableBall extends MovableBall implements Bounceable {
    public BounceableBall(int x, int y, int radius, Color color, int dx, int dy) {
        super(x, y, radius, color, dx, dy);
    }

    public BounceableBall(int x, int y, int radius, Color color, Vector vector) {
        super(x, y, radius, color, vector);
    }

    @Override
    public void bounce(Boundary other) {
        if (isCollided(other)) {
            Boundary intersection = getBoundary().intersection(other);

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
