import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class TestEventFrame extends JFrame implements KeyListener, MouseMotionListener {
    public TestEventFrame(String title) {
        super(title);
        addKeyListener(this);
        addMouseMotionListener(this);
    }

    public static void main(String[] args) {
        TestEventFrame frame = new TestEventFrame("E V E N T   L I S T E N E R");

        frame.setSize(600, 500);

        frame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("* KEY TYPED: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("* KEY PRESSED: " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("* KEY RELEASED: " + e.getKeyChar());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("* MOUSE DRAGGED: ( " + e.getX() + ", " + e.getY() + " )");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("* MOUSE MOVED: ( " + e.getX() + ", " + e.getY() + " )");
    }
}
