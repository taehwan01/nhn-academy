package com.nhnacademy;

import java.awt.Rectangle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ball implements Regionable {
    static int count = 0;
    int id = ++count;
    Logger logger = LogManager.getLogger(this.getClass().getSimpleName());
    Rectangle region;

    public Ball(long x, long y, long radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("* 반지름이 자연수가 아닙니다. 반지름을 확인해주세요.");
        }
        if (x + radius > Integer.MAX_VALUE || y + radius > Integer.MAX_VALUE || x - radius < Integer.MIN_VALUE
                || y - radius < Integer.MIN_VALUE) {
            // x, y, radius가 int의 범위를 벗어나는지 확인
            throw new IllegalArgumentException("* 공이 범위를 벗어났습니다. 좌표 및 반지름을 확인해주세요.");
        }
        this.region = new Rectangle((int) x - (int) radius, (int) y - (int) radius, (int) radius * 2, (int) radius * 2);
    }

    public int getID() {
        return this.id;
    }

    public int getX() {
        return (int) getRegion().getCenterX();
    }

    public int getY() {
        return (int) getRegion().getCenterY();
    }

    public void setX(int x) {
        region.setLocation(x - getRadius(), getY() - getRadius());
    }

    public void setY(int y) {
        region.setLocation(getX() - getRadius(), y - getRadius());
    }

    public int getWidth() {
        return (int) getRegion().getWidth();
    }

    public int getHeight() {
        return (int) getRegion().getHeight();
    }

    public int getRadius() {
        return region.width / 2;
    }

    public Rectangle getRegion() {
        return this.region;
    }

    @Override
    public String toString() {
        return String.format("( %d, %d, %d )", getX(), getY(), getRadius());
    }
}
