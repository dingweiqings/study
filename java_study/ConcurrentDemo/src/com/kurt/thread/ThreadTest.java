package com.kurt.thread;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2018/11/27
 */
public class ThreadTest extends Thread{

    @Override
    public void run() {
       this.interrupt();
        System.out.println("Thread.name "+Thread.currentThread().getName()+this.isInterrupted());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            //不管打断
          //  Thread.interrupted();
            System.out.println("Interrupt by other");
            System.out.println("Thread.name "+Thread.currentThread().getName()+this.isInterrupted());
        }
    }
}
