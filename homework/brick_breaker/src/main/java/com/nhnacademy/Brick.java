package com.nhnacademy;

import java.awt.Color;

public class Brick extends PaintableBox {
    private int durability; // 버틸 수 있는 횟수

    public Brick(int x, int y, int width, int height, Color color, int durability) {
        super(x, y, width, height, color);
        this.durability = durability;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public void hit() {
        if (getDurability() > 0) {
            setDurability(getDurability() - 1);
        }
    }
}
