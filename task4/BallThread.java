package task4;

public class BallThread extends Thread {
    private Ball ball;
    private BallThread ballWait;

    public BallThread(Ball ball) {
        this.ball = ball;
    }

    public BallThread(Ball ball, BallThread ballWait) {
        this.ball = ball;
        this.ballWait = ballWait;
    }

    @Override
    public void run() {
        try {
            if (ballWait != null) {
                ballWait.join();
            }
            for (int i = 1; i < 1000; i++) {
                ball.move();
                Thread.sleep(5);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
