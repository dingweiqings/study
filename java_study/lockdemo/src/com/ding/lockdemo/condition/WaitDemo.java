package com.ding.lockdemo.condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaitDemo {
    public static void main(String[] args) throws InterruptedException {
        Object lock=new Object();
        Thread thread1=new Thread(()->{
            synchronized (lock){
                try {
                    System.out.println("Thread 1 get lock");
                    System.out.println("Wait on condition");
                    lock.wait(TimeUnit.SECONDS.toMillis(10));
                    System.out.println("Wake up");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        Thread thread2=new Thread(()->{
            try {
                synchronized (lock){
                    System.out.println("Thread 2 get lock");
                    Thread.sleep(10000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();
        Thread.sleep(1000);
        thread2.start();

    }
}
