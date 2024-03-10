package com.nhnacademy;

public class Vector {
    private int dx;
    private int dy;

    public Vector() {
        this(0, 0);
    }

    public Vector(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDX() {
        return this.dx;
    }

    public int getDY() {
        return this.dy;
    }

    public void setDX(int dx) {
        this.dx = dx;
    }

    public void setDY(int dy) {
        this.dy = dy;
    }

    public void set(int dx, int dy) {
        setDX(dx);
        setDY(dy);
    }

    public void set(Vector vector) {
        setDX(vector.getDX());
        setDY(vector.getDY());
    }

    public void turnDX() {
        setDX(-getDX());
    }

    public void turnDY() {
        setDY(-getDY());
    }
}
