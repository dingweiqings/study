package com.ding.lockdemo.condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        Lock lock=new ReentrantLock();
        Condition condition=lock.newCondition();

        Thread thread1=new Thread(()->{
            lock.lock();
            try {
                System.out.println("Thread1 get lock");
                System.out.println("Wait on condition");
                condition.awaitNanos(TimeUnit.SECONDS.toNanos(100));
               // condition.await();
                System.out.println("Wake up");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.unlock();
        });

        Thread thread2=new Thread(()->{
            try {
                lock.lockInterruptibly();
                System.out.println("Thread 2 get lock");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.unlock();
        });
        thread1.start();
        Thread.sleep(100);
        thread2.start();
    }
}
