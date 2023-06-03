package task3;

import java.awt.*;
import java.awt.geom.Ellipse2D;


public class Ball {
    private Component canvas;
    private static final int SIZE = 20;
    private int x;
    private int y;
    private int dx;
    private int dy;
    private Color color;
    private int priority;

    public Ball(Component canvas, Color color, int priority) {
        this.canvas = canvas;
        this.color = color;
        this.priority = priority;

        dx = 2;
        dy = 2;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fill(new Ellipse2D.Double(x, y, SIZE, SIZE));
    }

    public void move() {
        x += dx;
        y += dy;

        if (x < 0) {
            x = 0;
            dx = -dx;
        }
        if (x + SIZE >= canvas.getWidth()) {
            x = canvas.getWidth() - SIZE;
            dx = -dx;
        }
        if (y < 0) {
            y = 0;
            dy = -dy;
        }
        if (y + SIZE >= canvas.getHeight()) {
            y = canvas.getHeight() - SIZE;
            dy = -dy;
        }

        canvas.repaint();
    }

    public void startMoving() {
        BallThread ballThread = new BallThread(this, priority);
        ballThread.start();
    }
}
