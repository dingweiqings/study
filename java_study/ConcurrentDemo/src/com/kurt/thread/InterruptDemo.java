package com.kurt.thread;

import java.util.concurrent.Executors;
import java.util.function.DoubleUnaryOperator;

/**
 * 此Demo在于演示Thread.interrupted()，类调用和worker.interrupted()，实例调用的区别
 * 类调用始终是当前线程
 * worker.interrupted()返回的是线程对象当前的中断位
 * 意外的发现，当在其他线程内调用worker.IsInterrupted()-检查某个线程对象的中断位,结果也是会清除中断位；在自己线程内调用是和jdk api中说的一样，只是返回不会清除
 * 协作通知机制：
 *  1. 如何协作，interrupt
 *  2. 如何判断是否收到通知
 *  3. 收到通知如何响应
 *  4. 有些行为是不可中断的
 *
 *  几种行为：sleep ,wait ，join 收到中断通知，会抛出InterruptedException常，并清除中断位
 *	阻塞在可中断io上，抛出ClosedByInterruptException，并设置中断位
 *  阻塞在selector上，会立即返回,返回截止到目前获取到的keys，类似于wakeUp方法，并设置中断位
 *  其他情况都会设置中断位
 *
 *
 * 标志位优雅停止
 * @author FastoneTeam
 * @date 2022/3/18 下午9:26
 */
public class InterruptDemo {

	public static void main(String[] args) {
	//	instanceCall();
		classCall();
	}

	/**
	 * 类调用
	 */
	public static void classCall(){
		Thread thread=new Thread(()->{
			for(int i=0;i<1000000000;i++){
				System.out.println("I am working");
				if(Thread.interrupted()){
					System.out.println("On no,我被中断了");
				}
			}

		});
		thread.start();
		thread.interrupt();
		//返回的是false，因为main线程没有被中断
		System.out.println("类调用："+Thread.interrupted());
		System.out.println("After Is interrupted: "+thread.isInterrupted());

		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 实例调用
	 */
	public static void instanceCall(){
		Thread worker=new Thread(()->{
			for(int i=0;i<20;i++){
				System.out.println("I am working");
				//自己轮轮询，打印的永远是true，不会被清除
//				if(Thread.currentThread().isInterrupted()){
//					System.out.println("On 我被中断了");
//				}
				if(Thread.interrupted()){
					System.out.println("On no,我被中断了");
				}
			}

		});
		worker.setUncaughtExceptionHandler((t,e)->{
			System.out.println(t.getName()+"出现了异常"+e.getMessage());
			e.printStackTrace();
		});
		worker.start();
		//main 线程中断worker
		worker.interrupt();
		//这里只有第一次调用worker.isInterrupted()是true,第二次还是会被清除
		//interrupted()永远是false，因为main线程没有被中断过
		for(int i=0;i<5;i++) {
			System.out.println("Thread isInterrupted: "+worker.isInterrupted() );
			System.out.println("Thread interrupted: "+worker.interrupted());
		}

		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 在其他线程内调用isInterrupted,也只是第一次返回true，后面都返回false，表示也是会清除中断位
	 * 不过协作通知机制设计是让每个线程自己查看自己的中断位，别的线程查看也没有用
	 */
	public static void callInterruptedInOtherThread(){
		Thread worker=new Thread(()->{
			for(int i=0;i<20;i++){
				System.out.println("I am working");
				//自己轮轮询，打印的永远是true，不会被清除
				if(Thread.currentThread().isInterrupted()){
					System.out.println("On 我被中断了");
				}
			}

		});
		worker.setUncaughtExceptionHandler((t,e)->{
			System.out.println(t.getName()+"出现了异常"+e.getMessage());
			e.printStackTrace();
		});
		worker.start();
		//main 线程中断worker
		worker.interrupt();
		//interrupted()永远是false，因为main线程没有被中断过
		for(int i=0;i<5;i++) {
			//这里只有第一次调用worker.isInterrupted()是true,第二次还是会被清除
			System.out.println("Thread isInterrupted: "+worker.isInterrupted() );
			System.out.println("Thread interrupted: "+worker.interrupted());
		}

		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
