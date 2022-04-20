package com.kurt;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException {
//	ThreadTest thread=new ThreadTest();
//	thread.start();
//	thread.interrupt();
//	//System.out.println("Thread.name "+Thread.currentThread().getName()+" "+Thread.interrupted());
//		int x=-11;
//		System.out.println(x>>>1);
		List<Integer> list=null;
		list.stream().forEach(System.out::println);
		MethodHandles.Lookup lookup=MethodHandles.lookup();
	//	MethodHandle constructor = lookup.findConstructor(Main.class, MethodType.methodType());
		//constructor.invokeWithArguments()
		MethodHandle handle=lookup.findConstructor(Main.class, MethodType.methodType(Main.class));
		handle.invoke()
	}
	//1 2 3

}
