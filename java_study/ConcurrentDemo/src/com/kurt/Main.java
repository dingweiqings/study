package com.kurt;

import com.kurt.thread.ThreadTest;

public class Main {

    public static void main(String[] args) {
	ThreadTest thread=new ThreadTest();
	thread.start();
	thread.interrupt();
	//System.out.println("Thread.name "+Thread.currentThread().getName()+" "+Thread.interrupted());
    }
}
