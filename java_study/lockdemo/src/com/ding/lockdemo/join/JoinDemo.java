package com.ding.lockdemo.join;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2019/2/3
 */
public class JoinDemo {

    public static void main(String[] args) {
       Thread thread=new Thread(new Runnable() {
           @Override
           public void run() {
             System.out.println("Other thread");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       });
       thread.start();
        try {
            //表示先执行完join的线程
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main end");
    }




}
