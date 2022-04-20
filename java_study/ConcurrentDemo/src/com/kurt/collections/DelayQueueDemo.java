package com.kurt.collections;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author FastoneTeam
 * @date 2022/3/20 下午1:23
 */
public class DelayQueueDemo {
	static class MyElement implements Delayed {

		@Override
		public long getDelay(TimeUnit unit) {
			return 0;
		}

		@Override
		public int compareTo(Delayed o) {
			return 0;
		}
	}
	public static void main(String[] args) {
		DelayQueue<MyElement> queue=new DelayQueue<>();
		queue.put(new MyElement());
		queue.poll();
	}
}
