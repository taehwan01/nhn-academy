package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class GameWorld extends JPanel implements KeyListener {
    private static final Color BACKGROUND_COLOR = Color.WHITE;
    private static final Color OBJECT_COLOR = Color.BLACK;
    private static final int DEFAULT_DELTA_TIME = 10;
    private static final int TOP_INSETS = 28;
    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 700;
    private static final int BLOCK_WIDTH = 100;
    private static final int BLOCK_HEIGHT = 20;

    List<Regionable> regionableList = new LinkedList<>();
    List<Brick> brickList = new LinkedList<>();
    List<Wall> wallList = new ArrayList<>();
    BoundingBall rocketBall;
    UserBlock block;

    private int dt = DEFAULT_DELTA_TIME;

    public GameWorld() {
        super();
        setBackground(BACKGROUND_COLOR);
        rocketBall = new BoundingBall(200, 300, 20, OBJECT_COLOR, 2, -2);
        block = new UserBlock((FRAME_WIDTH - BLOCK_WIDTH) / 2, FRAME_HEIGHT - BLOCK_HEIGHT - TOP_INSETS, BLOCK_WIDTH,
                BLOCK_HEIGHT);
        add(block);
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }

    public int getCount() {
        return regionableList.size();
    }

    public Regionable get(int index) {
        return regionableList.get(index);
    }

    public int getWallCount() {
        return wallList.size();
    }

    public Wall getWall(int index) {
        return wallList.get(index);
    }

    public int getBrickCount() {
        return brickList.size();
    }

    public Brick getBrick(int index) {
        return brickList.get(index);
    }

    public int getDT() {
        return dt;
    }

    public void setDT(int dt) {
        this.dt = dt;
    }

    public void add(Regionable obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }

        if (obj instanceof Wall)
            wallList.add((Wall) obj);

        if (obj instanceof Brick)
            brickList.add((Brick) obj);

        regionableList.add(obj);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        rocketBall.paint(g);
        block.paint(g);
        for (Regionable obj : regionableList) {
            if (obj instanceof Paintable) {
                ((Paintable) obj).paint(g);
            }
        }
    }

    public void remove(Regionable obj) {
        regionableList.remove(obj);
    }

    public void moveBall() {
        rocketBall.move();

        for (int i = 0; i < getCount(); i++) {
            Regionable other = get(i);
            if (other != rocketBall) {
                (rocketBall).bounce(other);
                if (other instanceof Brick && (((Brick) other).getDurability() == 0)) {
                    remove(other);

                }
            }
        }

        repaint();
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            moveBall();
            try {
                Thread.sleep(getDT());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        // block이 벽을 만나면 움직이지 않게 하기
        for (int i = 0; i < getWallCount(); i++) {
            Wall wall = getWall(i);
            if (block.getX() + block.getMovement() > wall.getX() + wall.getWidth() && keyCode == KeyEvent.VK_LEFT) {
                block.moveLeft();
                if (wall.getX() + wall.getWidth() > block.getX()) {
                    block.setX(wall.getX() + wall.getWidth());
                }
            } else if (block.getX() < wall.getX() && keyCode == KeyEvent.VK_RIGHT) {
                block.moveRight();
                if (block.getX() + block.getWidth() > wall.getX()) {
                    block.setX(wall.getX() - block.getWidth());
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

}
