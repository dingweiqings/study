package com.ding.lockdemo.reentrantlock;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2019/2/3
 */
public class ConsumeThread implements Runnable {
    Lock lock;
    List<String> list;
    Condition condition;
    public ConsumeThread(Lock lock, List<String> list) {
        this.lock = lock;
        this.list = list;
    }

    public ConsumeThread(Lock lock, List<String> list, Condition condition) {
        this.lock = lock;
        this.list = list;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            //  threada.interrupt();
                for(;;){
                    for (int i = 0; i < 10; i++) {
                        list.add(i+"");
                        System.out.println("添加了" + (i + 1) + "个元素!");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //即使notify还是要等到10次循环结束再释放锁
                    //唤醒的是同一个锁的线程
                    //生产了数据，通知等待的消费者
                    condition.signal();
                    System.out.println("已发出通知！");
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        } finally {
            lock.unlock();
        }
    }
}
