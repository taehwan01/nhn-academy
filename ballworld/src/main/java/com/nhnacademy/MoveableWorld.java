package com.nhnacademy;

public class MoveableWorld extends World {
    static final int DEFAULT_DT = 500;
    private int moveCount;
    private int maxMoveCount;
    private int dt = DEFAULT_DT; // delta time 단위 시간

    public MoveableWorld() {
        super();
    }

    public void reset() {
        this.moveCount = 0;
    }

    public void move() {
        if (getMaxMoveCount() == 0 || getMovementCount() < getMaxMoveCount()) {
            // List<Ball> removeList = new LinkedList<>();

            for (int i = 0; i < getCount(); i++) {
                Ball ball = get(i);
                if (ball instanceof MoveableBall) {
                    ((MoveableBall) ball).move();
                    for (int j = 0; j < getCount(); j++) {
                        Ball otherBall = get(j);
                        if (ball != otherBall && ((MoveableBall) ball).isCollided((MoveableBall) otherBall)) {
                            logger.info("Ball #{}과 OtherBall #{}이 충돌했습니다.", ball.getID(), otherBall.getID());
                            ((BoundedBall) ball).bounce((BoundedBall) otherBall);

                            // removeList.add(otherBall);
                        }
                    }
                }
            }

            // for (Ball ball : removeList) {
            // remove(ball);
            // }

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

    public void setDT(int dt) {
        if (dt < 0) {
            throw new IllegalArgumentException();
        }

        this.dt = dt;
    }

    public int getDT() {
        return this.dt;
    }
}
