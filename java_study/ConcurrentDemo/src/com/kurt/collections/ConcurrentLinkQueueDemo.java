package com.kurt.collections;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author FastoneTeam
 * @date 2022/4/16 下午8:08
 */
public class ConcurrentLinkQueueDemo {
	public static void main(String[] args) {
		ConcurrentLinkedQueue<Integer> queue=new ConcurrentLinkedQueue<>();
		queue.offer(1);
//		queue.offer(2);
//		queue.offer(3);
		System.out.println(queue.poll());
//		System.out.println(queue.poll());
//		System.out.println(queue.poll());

	}
}
