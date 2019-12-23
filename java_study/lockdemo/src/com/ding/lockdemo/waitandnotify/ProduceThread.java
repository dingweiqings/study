package com.ding.lockdemo.waitandnotify;

import com.ding.lockdemo.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2019/2/3
 */
public class ProduceThread  implements Runnable{
    Object lock;
    List<String> list;

    public ProduceThread(Object lock, List<String> list) {
        this.lock = lock;
        this.list = list;
    }



    @Override
    public void run() {
        try {

            //在调用wait方法时，会检查中断变量，如果为true，则抛中断异常，让
            //在之前被中断也会抛异常
            //     Thread.currentThread().interrupt();
            synchronized (lock) {
                //list 不为空，可以消费
                List<String> removeList=new ArrayList<>();
                for(;;){
                    if (Utils.isEmpty(list)) {
                        System.out.println("list 为空，停止消费"
                                + System.currentTimeMillis());
                        //list 为空，不再消费，告诉生产者继续生产
                        //满足条件wait，此时如果被中断会抛异常
                        lock.notify();
                        lock.wait();


//                                notify必须放在前面，因为wait之后便阻塞了
//                                lock.notify();
//                                lock.wait();
                    }
                    for(String e:list){
                        System.out.println("消费 "+e);
                        removeList.add(e);
                    }
                    list.removeAll(removeList);
                    removeList.clear();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
