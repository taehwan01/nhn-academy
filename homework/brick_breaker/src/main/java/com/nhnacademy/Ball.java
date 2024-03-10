package com.nhnacademy;

import java.awt.Rectangle;

public class Ball implements Regionable {
    private static int count = 0;
    private int id = ++count; // id값은 증가시킨 count로 초기화한 멤버 변수
    private Rectangle region; // 이 Ball이 차지하는 사각 영역(Rectangle)

    public Ball(int x, int y, int radius) {
        this.region = new Rectangle(x - radius, y - radius, radius * 2, radius * 2);
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public int getX() {
        return (int) this.getRegion().getCenterX();
    }

    public void setX(int x) {
        this.region.setLocation(x - this.getWidth() / 2, this.getY() - this.getHeight() / 2);
    }

    @Override
    public int getY() {
        return (int) this.getRegion().getCenterY();
    }

    public void setY(int y) {
        this.region.setLocation(this.getX() - this.getWidth() / 2, y - this.getHeight() / 2);
    }

    public int getWidth() {
        return (int) this.getRegion().getWidth();
    }

    public int getHeight() {
        return (int) this.getRegion().getHeight();
    }

    @Override
    public Rectangle getRegion() {
        return new Rectangle(this.region);
    }

    @Override
    public String toString() {
        return String.format("* Ball ( %d, %d, %d, %d )", this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
}

// public double getShortestDistance(Regionable other) {
// // 두 Regionable 객체의 각 모든 점 사이의 거리를 계산하여 그 중 최소값을 반환
// double shortestDistance = Double.MAX_VALUE;
// for (int i = (int) this.getRegion().getMinX(); i <= (int)
// this.getRegion().getMaxX(); i++) {
// for (int j = (int) other.getRegion().getMinY(); j <= (int)
// other.getRegion().getMaxY(); j++) {
// double distance = Math.sqrt(Math.pow(i - other.getX(), 2) + Math.pow(j -
// other.getY(), 2));
// if (distance < shortestDistance) {
// shortestDistance = distance;
// }
// }
// }
// return shortestDistance;
// }