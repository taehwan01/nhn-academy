package com.nhnacademy;

import java.awt.Rectangle;

public class Brick implements Regionable {
    private static int count = 0;
    private int id = ++count; // id값은 증가시킨 count로 초기화한 멤버 변수
    private Rectangle region; // 이 Brick이 차지하는 영역(Rectangle)

    public Brick() {
        this(0, 0, 1, 1);
    }

    public Brick(int x, int y, int width, int height) {
        this.region = new Rectangle(x - width / 2, y - height / 2, width, height);
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
        return String.format("* Brick ( %d, %d, %d, %d )", this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
}