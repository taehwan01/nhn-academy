package com.nhnacademy;

public class MoveableWorld extends World {
    static final int DEFAULT_DT = 20;
    private int moveCount;
    private int maxMoveCount;
    private int dt = DEFAULT_DT; // delta time 단위 시간

    public MoveableWorld() {
        super();
    }

    public int getDT() {
        return this.dt;
    }

    public void setDT(int dt) {
        if (dt < 0) {
            throw new IllegalArgumentException();
        }

        this.dt = dt;
    }

    public void reset() {
        this.moveCount = 0;
    }

    public void move() {
        if (getMaxMoveCount() == 0 || (getMovementCount() < getMaxMoveCount())) {
            for (int i = 0; i < getCount(); i++) {
                Regionable obj = get(i);

                if (obj instanceof Moveable) {
                    ((Moveable) obj).move();

                    if (obj instanceof Bounded) {
                        for (int j = 0; j < getCount(); j++) {
                            Regionable other = get(j);

                            if (obj != other && obj.getRegion().intersects(other.getRegion())) {
                                logger.info("Ball #{}과 OtherBall #{}이 충돌했습니다.", obj.getID(), other.getID());
                                ((Bounded) obj).bounce(other);
                            }
                        }
                    }
                }
            }
            moveCount++;
            repaint();
        }
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            move();
            try {
                Thread.sleep(getDT());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public int getMovementCount() {
        return this.moveCount;
    }

    public int getMaxMoveCount() {
        return this.maxMoveCount;
    }

    public void setMaxMoveCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException();
        }

        this.maxMoveCount = count;
    }
}
