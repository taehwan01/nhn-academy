package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;

public class PaintableBall extends Ball implements Paintable {
    static final Color DEFAULT_COLOR = Color.BLACK;
    private Color color;

    public PaintableBall(int x, int y, int radius) {
        this(x, y, radius, DEFAULT_COLOR);
    }

    public PaintableBall(int x, int y, int radius, Color color) {
        super(x, y, radius);

        if (color == null) {
            throw new IllegalArgumentException("* 색상이 null입니다. 색상을 확인해주세요.");
        }

        this.color = color;
    }

    public synchronized Color getColor() {
        return this.color;
    }

    /**
     * 
     * @param color
     * @throws IllegalArgumentException color는 null을 허용하지 않습니다.
     */
    public synchronized void setColor(Color color) {
        // synchronized를 사용하여 멀티스레드 환경에서의 안정성을 보장
        if (color == null) {
            throw new IllegalArgumentException("* 색상이 null입니다. 색상을 확인해주세요.");
        }

        this.color = color;
    }

    public void paint(Graphics g) {
        if (g == null) {
            throw new IllegalArgumentException("* 그래픽스 객체가 null입니다. 그래픽스 객체를 확인해주세요.");
        }
        Color originalColor = g.getColor();
        g.setColor(this.getColor());
        g.fillOval(this.getX() - this.getRadius(), this.getY() - this.getRadius(), this.getRadius() * 2,
                this.getRadius() * 2); // x, y좌표는 원의 중심
        g.setColor(Color.BLACK);
        g.drawRect(getRegion().x, getRegion().y, getRegion().width, getRegion().height);
        g.setColor(originalColor); // 남의 붓으로 그린 후에는 원래 붓으로 되돌려놓는다.
    }
}
