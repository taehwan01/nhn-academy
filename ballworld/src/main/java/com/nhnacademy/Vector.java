package com.nhnacademy;

import java.util.Objects;

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

    // +, -
    public void add(Vector other) {
        if (other == null) {
            throw new IllegalArgumentException();
        }
        setDX(getDX() + other.getDX());
        setDY(getDY() + other.getDY());
    }

    public void substract(Vector other) {
        if (other == null) {
            throw new IllegalArgumentException();
        }
        setDX(getDX() - other.getDX());
        setDY(getDY() - other.getDY());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Vector other = (Vector) obj;
        return getDX() == other.getDX() && getDY() == other.getDY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDX(), getDY());
    }

}
