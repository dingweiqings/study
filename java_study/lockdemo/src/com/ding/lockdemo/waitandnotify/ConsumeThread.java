package com.ding.lockdemo.waitandnotify;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import java.util.List;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2019/2/3
 */
public class ConsumeThread implements Runnable {
    Object lock;
    List<String> list;

    public ConsumeThread(Object lock, List<String> list) {
        this.lock = lock;
        this.list = list;
    }
    @Override
    public void run() {
        try {
            //  threada.interrupt();
            synchronized (lock) {
                for(;;){
                    for (int i = 0; i < 10; i++) {
                        list.add(i+"");
                        System.out.println("添加了" + (i + 1) + "个元素!");
                        Thread.sleep(1000);
                    }
                    //即使notify还是要等到10次循环结束再释放锁
                    //唤醒的是同一个锁的线程
                    //生产了数据，通知等待的消费者
                    lock.notify();
                    System.out.println("已发出通知！");
                    lock.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
