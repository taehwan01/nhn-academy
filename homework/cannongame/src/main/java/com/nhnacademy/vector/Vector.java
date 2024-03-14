package com.nhnacademy.vector;

public class Vector {
    // 방향
    private int dx;
    private int dy;

    public Vector() {
        this(0, 0);
    }

    public Vector(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Vector(Vector other) {
        this(other.getDX(), other.getDY());
    }

    public int getDX() {
        return dx;
    }

    public void setDX(int dx) {
        this.dx = dx;
    }

    public int getDY() {
        return dy;
    }

    public void setDY(int dy) {
        this.dy = dy;
    }

    public void set(int dx, int dy) {
        setDX(dx);
        setDY(dy);
    }

    public void set(Vector other) {
        setDX(other.getDX());
        setDY(other.getDY());
    }

    public void add(Vector other) {
        setDX(getDX() + other.getDX());
        setDY(getDY() + other.getDY());
    }

    public void subtract(Vector other) {
        setDX(getDX() - other.getDX());
        setDY(getDY() - other.getDY());
    }

    public void multiply(int factor) { // 속도 조절할 때 사용
        setDX(getDX() * factor);
        setDY(getDY() * factor);
    }
}
