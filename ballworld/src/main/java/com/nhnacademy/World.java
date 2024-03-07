package com.nhnacademy;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class World extends JPanel {
    static final int FRAME_TOP_INSET = 28;
    transient List<Ball> ballList = new LinkedList<>();
    static Logger logger = LogManager.getLogger(World.class.getName());

    public World() {
        super();
    }

    public Ball isBallOverlapped(Ball ball) {
        /**
         * for (Ball b : ballList) {
         * int xDistance = b.getX() - ball.getX();
         * int yDistance = b.getY() - ball.getY();
         * double distance = Math.sqrt((double) xDistance * xDistance + yDistance *
         * yDistance);
         * 
         * if (distance < b.getRadius() + ball.getRadius()) {
         * return b;
         * }
         * }
         * 
         * return null;
         */
        // 코드를 바꾼 이유는, Ball 이외의 도형에도 적용할 수 있기 때문에 확장에 용이하다.
        for (Ball b : ballList) {
            if (b.getRegion().intersects(ball.getRegion())) {
                return b;
            }
        }
        return null;
    }

    /**
     * Add a ball to the world.
     * 
     * @param ball
     * @throws IllegalArgumentException 공이 null, 벽을 넘어감, 다른 공과 겹칠 때
     */
    public void add(Ball ball) {
        if (ball == null) {
            logger.error("공이 null입니다.");
            throw new IllegalArgumentException();
        }

        if (ball.getX() - ball.getRadius() < 0 || ball.getX() + ball.getRadius() > getWidth()
                || ball.getY() - ball.getRadius() < 0
                || ball.getY() + ball.getRadius() > getHeight() - FRAME_TOP_INSET) {
            logger.error("추가하려는 공이 벽을 넘어갑니다.");
            throw new IllegalArgumentException();
        }

        Ball existingBall = isBallOverlapped(ball);
        if (existingBall != null) {
            logger.error("추가하려는 공은 다른 공 {} 과 겹칩니다.", existingBall);
            throw new IllegalArgumentException();
        }

        if (ball instanceof BoundedBall) {
            ((BoundedBall) ball).setBounds(getBounds());
        }
        ballList.add(ball);

        logger.trace("{} 추가: {}", ball.getClass().getSimpleName(), ball);
    }

    public void remove(Ball ball) {
        ballList.remove(ball);
    }

    @Override
    public void remove(int i) {
        ballList.remove(i);
    }

    public int getCount() {
        return ballList.size();
    }

    public Ball get(int index) {
        return ballList.get(index);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Ball ball : ballList) {
            if (ball instanceof PaintableBall) {
                ((PaintableBall) ball).paint(g);
            }
        }
    }
}
