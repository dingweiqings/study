package com.ding.lockdemo.waitandnotify;

import com.ding.lockdemo.waitandnotify.ConsumeThread;
import com.ding.lockdemo.waitandnotify.ProduceThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2019/2/3
 */
//典型的是生成者消费者模式，池的数量为10
    //必须是同一个锁
public class WaitAndNotifyDemo {

    public static void main(String[] args) {
        Object lock=new Object();
        List<String> list=new ArrayList<>();
//        for(int i=0;i<5;i++){
//            list.add(i+"");
//        }
        Thread produce=new Thread(new ProduceThread(lock,list));
        Thread consume=new Thread(new ConsumeThread(lock,list));
        consume.start();
        produce.start();;

    }

}
