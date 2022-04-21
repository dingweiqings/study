package com.kurt.thread;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap();
        map.put(1, 2);
        map.put(1, 3);
    }
}
