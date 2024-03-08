package com.nhnacademy;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class World extends JPanel {
    static final int FRAME_TOP_INSET = 28;
    transient List<Regionable> regionableList = new LinkedList<>();
    static Logger logger = LogManager.getLogger(World.class.getName());

    public World() {
        super();
    }

    public Regionable isOverlapped(Regionable other) {
        for (Regionable r : regionableList) {
            if ((r instanceof Bounded || other instanceof Bounded) && r.getRegion().intersects(other.getRegion())) {
                return r;
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
    public void add(Regionable obj) {
        if (obj == null) {
            logger.error("공이 null입니다.");
            throw new IllegalArgumentException();
        }

        if (obj.getX() - obj.getRegion().getWidth() / 2 < 0 || obj.getX() + obj.getRegion().getWidth() / 2 > getWidth()
                || obj.getY() - obj.getRegion().getHeight() / 2 < 0
                || obj.getY() + obj.getRegion().getHeight() / 2 > getHeight() - FRAME_TOP_INSET) {
            logger.error("추가하려는 공이 벽을 넘어갑니다.");
            throw new IllegalArgumentException();
        }

        for (Regionable other : regionableList) {
            if ((obj instanceof Bounded || other instanceof Bounded) && obj.getRegion().intersects(other.getRegion())) {
                logger.error("추가하려는 공은 다른 공 {} 과 겹칩니다.", obj);
                throw new IllegalArgumentException();
            }
        }

        if (obj instanceof Bounded)
            ((Bounded) obj).setBoundary(getBounds());
        regionableList.add(obj);

        logger.trace("{} 추가: {}", obj.getClass().getSimpleName(), obj);
    }

    public void remove(Regionable obj) {
        regionableList.remove(obj);
    }

    @Override
    public void remove(int i) {
        regionableList.remove(i);
    }

    public int getCount() {
        return regionableList.size();
    }

    public Regionable get(int index) {
        return regionableList.get(index);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Regionable obj : regionableList) {
            if (obj instanceof Paintable) {
                ((Paintable) obj).paint(g);
            }
        }
    }
}
