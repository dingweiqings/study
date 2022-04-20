package com.ding;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 去除一个队列中满足条件的节点，留下不满足条件的组成新的队列返回
 * @author FastoneTeam
 * @date 2022/4/16 下午4:56
 */
public class Problem1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner=new Scanner(new FileInputStream(new File("/my_project/study/code_study/queue/main/input.txt")));
		while (scanner.hasNextLine()){
			MyQueue queue=new MyQueue();
			String str=scanner.nextLine();
			List<Integer> list = Arrays.stream(str.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
			queue.create(list.toArray(new Integer[list.size()]));
			fun(queue);
			System.out.println("Input: "+str+ " Output:  "+queue.print());
		}

	}
	public static void  fun(MyQueue queue){
		MyQueue.Node p=queue.head.next;
		MyQueue.Node trail= queue.head;
		MyQueue.Node oldNext=null;
		while(p!=null){
			oldNext=p.next;
			if(p.data>=5){
				trail.next=p.next;
				p.next=null;
			}else{
				trail=p;
			}
			p=oldNext;
		}
		queue.tail=trail;
	}

}
