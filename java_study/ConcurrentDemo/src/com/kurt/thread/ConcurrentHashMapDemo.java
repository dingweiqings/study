package com.kurt.thread;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 17; i++) {
            map.put(i, i+1);
        }


    }
}
