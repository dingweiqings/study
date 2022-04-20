package com.kurt.collections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/** 不可使用fori 这种遍历，会破坏线程安全，
 * fori 拿到的永远是最新的数组，而COWIterator会将snapshot拷贝一份
 * @author FastoneTeam
 * @date 2022/3/27 下午5:27
 */
public class COWList {
	public static void main(String[] args) throws IOException {
			CopyOnWriteArrayList<Integer> shareList=new CopyOnWriteArrayList<>();
			shareList.add(1);
			shareList.add(2);
			shareList.add(3);
			Thread worker1=new Thread(()->{

				for(int i=0;i<10;i++){
					System.out.println("Set i " +i);
					shareList.set(0,i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				shareList.remove(2);

			});
			worker1.start();
			Thread woker2 =new Thread(()->{
				int size=shareList.size();
				while (true){
					for(int i=0;i<size;i++){
						System.out.println("Read "+shareList.get(i));
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

			});
			woker2.start();
			System.in.read();
	}
	/**
	 * foreach迭代,都是转成iterator，可javap -v out.class 验证
	 */
	public static void foreach(){
		CopyOnWriteArrayList<Integer> list=new CopyOnWriteArrayList<>();
		list.add(1);
		list.add(2);
		for(Integer i:list){
			System.out.println(i);
		}
	}
	/**
	 * foreach迭代,都是转成iterator，可javap -v out.class 验证
	 */
	public static void arraylistforeach(){
		ArrayList<Integer> arrayList=new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		for(Integer i:arrayList){
			System.out.println(i);
		}
	}
}
