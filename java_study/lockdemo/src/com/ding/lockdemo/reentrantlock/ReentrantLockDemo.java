package com.ding.lockdemo.reentrantlock;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2019/2/3
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        List<String> list=new ArrayList<>();
        Condition condition=lock.newCondition();
//        for(int i=0;i<5;i++){
//            list.add(i+"");
//        }
        Thread produce=new Thread(new ProduceThread(lock,list,condition));
        Thread consume=new Thread(new ConsumeThread(lock,list,condition));
        consume.start();
        produce.start();;

    }

}
