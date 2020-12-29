package ch05;

import java.util.concurrent.locks.ReentrantLock;

public class Ch05_09 {
    public static void main(String[] args) {

    }

    class AutoClosableReentrantLock extends ReentrantLock implements AutoCloseable {
        @Override
        public void close() {
            this.unlock();
        }
    }

    public AutoClosableReentrantLock lock() {
        AutoClosableReentrantLock lock = new AutoClosableReentrantLock();
        lock.lock();
        return lock;
    }
}
