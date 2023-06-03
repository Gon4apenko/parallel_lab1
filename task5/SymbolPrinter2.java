package task5;

public class SymbolPrinter2 {
    private final Object lock;
    private boolean isDashTurn;

    public SymbolPrinter2() {
        this.lock = new Object();
        this.isDashTurn = true;
    }

    public void print(char symbol, boolean isDash) {
        synchronized (lock) {
            for (int i = 0; i < 100; i++) {
                while (isDash != isDashTurn) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                for (int j = 0; j < 100; j++) {
                    System.out.print(symbol);
                }
                System.out.println();

                isDashTurn = !isDashTurn;
                lock.notifyAll();
            }
        }
    }
}