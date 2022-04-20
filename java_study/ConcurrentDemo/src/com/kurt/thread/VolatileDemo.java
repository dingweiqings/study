package com.kurt.thread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author FastoneTeam
 * @date 2022/3/19 下午8:06
 */
public class VolatileDemo {
	private boolean flag=false;
	private int a=0;
	public void write(int i) {
		flag=true;
		a=i;
		System.out.println("Write a:"+a);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
	public void read(){
		if(flag)
		System.out.println("Read a:"+a);
	}

	public static void main(String[] args) {
		int n=1000;
		System.out.println("Demo begin");
		VolatileDemo obj=new VolatileDemo();

		Thread worker1=new Thread(()->{
			for(int i=0;i<n;i++)
				obj.write(i);
		});
		Thread worker2=new Thread(()->{
			for(int i=0;i<n;i++)
			obj.read();
		});
		worker1.start();
		worker2.start();
	}
}
