package org.example.bigs.pretest.core.util.util;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 서버 인스턴스가 하나일 때 사용하는 락 관리 클래스 다중화되는 경우 사용할 수 없음.
 */
public class ApplicationLockProvider {

    private final Lock lock = new ReentrantLock();

    public boolean tryLock() {
        return lock.tryLock();
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return lock.tryLock(time, unit);
    }

    public void unlock() {
        lock.unlock();
    }

}
