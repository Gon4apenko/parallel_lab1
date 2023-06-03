package task3;

public class BallThread extends Thread {
    private Ball ball;

    public BallThread(Ball ball, int priority) {
        this.ball = ball;
        this.setPriority(priority);
    }

    @Override
    public void run() {
        try {
            while (true) {
                ball.move();

                Thread.sleep(5);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
