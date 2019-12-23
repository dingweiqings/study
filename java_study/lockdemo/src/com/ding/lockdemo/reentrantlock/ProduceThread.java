package com.ding.lockdemo.reentrantlock;

import com.ding.lockdemo.utils.Utils;

import java.util.ArrayList;
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
public class ProduceThread  implements Runnable {
    Lock lock;
    List<String> list;
    Condition condition;
    public ProduceThread(Lock lock, List<String> list) {
        this.lock = lock;
        this.list = list;
    }

    public ProduceThread(Lock lock, List<String> list, Condition condition) {
        this.lock = lock;
        this.list = list;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            //list 不为空，可以消费
            List<String> removeList = new ArrayList<>();
            for (; ; ) {
                if (Utils.isEmpty(list)) {
                    System.out.println("list 为空，停止消费"
                            + System.currentTimeMillis());
                    //list 为空，不再消费，告诉生产者继续生产
                    //满足条件wait，此时如果被中断会抛异常
                    condition.signal();
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

//                                signal必须放在前面，因为wait之后便阻塞了
//                                lock.notify();
//                                lock.wait();
                }
                for (String e : list) {
                    System.out.println("消费 " + e);
                    removeList.add(e);
                }
                list.removeAll(removeList);
                removeList.clear();
            }
        }finally {
            lock.unlock();
        }


    }
}
