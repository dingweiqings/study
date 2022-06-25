package com.kurt.collections;

import java.util.NavigableSet;
import java.util.Random;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class ConcurrentSkipMapDemo  {
    public static void main(String[] args) {
        Random random=new Random();
        random.nextInt();
//        ConcurrentMap<Integer,Integer> map=new ConcurrentSkipListMap<>();
//        for (int i = 0; i < 100; i++) {
//            map.put(i,i);
//        }
//        int skips=1;
//        for (;;) {
//            if ( --skips < 0)
//                break;
//            System.out.println(skips);
//        }
//        System.out.println(skips);
    }
    public static class MySkipListMap<K,V> extends ConcurrentSkipListMap{


    }
}
