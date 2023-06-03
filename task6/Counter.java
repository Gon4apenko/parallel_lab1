package task6;

//-----------Non synch------
//class Counter {
//    private int count = 0;
//
//    public void increment() {
//        count++;
//    }
//
//    public void decrement() {
//        count--;
//    }
//
//    public int getCount() {
//        return count;
//    }
//}

//---------------Synchronized method----------
//class Counter {
//    private int count = 0;
//
//    public synchronized void increment() {
//        count++;
//    }
//
//    public synchronized void decrement() {
//        count--;
//    }
//
//    public int getCount() {
//        return count;
//    }
//}

//------------------Synch block-------

//class Counter {
//    private int count = 0;
//
//    public void increment() {
//        synchronized (this) {
//            count++;
//        }
//    }
//
//    public void decrement() {
//        synchronized (this) {
//            count--;
//        }
//    }
//
//    public int getCount() {
//        return count;
//    }
//}


//-----------------Lock -----------------

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count = 0;
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            count--;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}
