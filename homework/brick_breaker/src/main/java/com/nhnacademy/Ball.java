package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball implements Regionable {
    private static int count = 0;
    private int id = ++count; // id값은 증가시킨 count로 초기화한 멤버 변수
    private Rectangle region; // 이 Ball이 차지하는 사각 영역(Rectangle)
    private Color color;

    public Ball(int x, int y, int radius) {
        this.region = new Rectangle(x, y, radius * 2, radius * 2);
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public int getX() {
        return (int) this.getRegion().getX();
    }

    public void setX(int x) {
        this.region.setLocation(x, this.getY());
    }

    @Override
    public int getY() {
        return (int) this.getRegion().getY();
    }

    public void setY(int y) {
        this.region.setLocation(this.getX(), y);
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

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }
}
