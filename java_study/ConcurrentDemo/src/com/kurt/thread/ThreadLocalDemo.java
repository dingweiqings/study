package com.kurt.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author FastoneTeam
 * @date 2022/3/27 上午10:47
 */
public class ThreadLocalDemo {
	public static void main(String[] args) {
		//Thead中有ThreadLocalMap成员
		//ThreadLocalMap 只是一个数组实现了map的功能,如果冲突则查找下一个槽
		//get时，也是如果冲突则查找下一个槽，同时会清理自己所走过位置的过期value
		threadLocalMapHashCode();

	}
	public static void threadLocalMapHashCode(){
		AtomicInteger integer=new AtomicInteger();
		System.out.println("Increment "+0x61c88647);
		for (int i = 0; i < 10; i++) {
			int hash=integer.addAndGet(0x61c88647);
			System.out.println("Hashcode:"+hash+" slot index:"+(hash & 15));

		}
	}
}
