package task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

public class BallCanvas extends JPanel {
    private List<Ball> balls = new ArrayList<>();
    private List<Rectangle> pockets;
    private List<Ball> ballsInPockets = new ArrayList<>();
    JLabel inPocketCounterLabel;

    private int inPocketCounter = 0;

    public void addBall(Ball b) {
        balls.add(b);
        updateBallCount();
    }

    public List<Rectangle> getPockets() {
        return pockets;
    }

    public void setInPocketCounterLabel(JLabel label) {
        this.inPocketCounterLabel = label;
    }

    public void updateBallCount() {
        inPocketCounter = ballsInPockets.size();
        inPocketCounterLabel.setText("Balls in Pockets: " + inPocketCounter);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        pockets = generatePockets();
        paintPockets(g2);

        ArrayList<Ball> remainingBalls = new ArrayList<>();

        for (Ball ball : balls) {
            if (ball.isInPocket()) {
                ballsInPockets.add(ball);
            } else {
                remainingBalls.add(ball);
                ball.draw(g2);
            }
        }

        balls = remainingBalls;

        updateBallCount();
    }

    private List<Rectangle> generatePockets() {
        List<Rectangle> pockets = new ArrayList<>();
        pockets.add(new Rectangle(20, 40, 20, 20));
        pockets.add(new Rectangle(60, this.getHeight() - 40, 20, 20));
        pockets.add(new Rectangle(this.getWidth() - 190, 100, 20, 20));
        pockets.add(new Rectangle(this.getWidth() - 40, this.getHeight() - 40, 20, 20));
        return pockets;
    }

    private void paintPockets(Graphics2D g2) {
        for (Rectangle pocket : pockets) {
            g2.setColor(Color.BLACK);
            g2.draw(pocket);
        }
    }
}
