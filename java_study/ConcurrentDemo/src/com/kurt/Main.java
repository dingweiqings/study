package com.kurt;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    public static void main(String[] args) {
	ThreadTest thread=new ThreadTest();
	thread.start();
	System.out.println("111");
	thread.interrupt();
	//System.out.println("Thread.name "+Thread.currentThread().getName()+" "+Thread.interrupted());
    }
}
