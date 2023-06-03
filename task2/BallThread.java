package task2;

class BallThread extends Thread {
    private Ball b;
    private BallCanvas canvas;

    public BallThread(Ball ball, BallCanvas canvas) {
        b = ball;
        this.canvas = canvas;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (b.isInPocket()) {
                    return;
                }
                b.move();
                Thread.sleep(5);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
