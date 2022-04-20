package com.ding;

/**
 * 自己实现一个双端队列，用链表实现
 * @author FastoneTeam
 * @date 2022/4/16 下午4:54
 */
public class MyQueue {
	Node head;
	Node tail;

	public MyQueue() {
		head=new Node();
		tail=head;
	}

	/**
	 * 入队
	 * @return
	 */
	public boolean enq(Integer value){
		Node node=new Node();
		node.setData(value);
		tail.next=node;
		tail=node;
		return  true;
	}
	public Integer deq(){
		Node oldHead=head;
		if(head.next!=null){
			//head.next=head.next.next;
			head = head.next;
			oldHead.next=null;
			return head.next.data;
		}
		return null;
	}




	public void create(Integer[] arr){
		for(int i=0;i<arr.length;i++){
			enq(arr[i]);
		}
	}
	public String print() {
		Node p = head.next;
		String str = "";
		while (p != null) {
			str += p.data;
			if(tail!=p){
				str+="->";
			}
			p = p.next;
		}
		return str;
	}

	public static void main(String[] args) {
		MyQueue qu=new MyQueue();
		qu.create(new Integer[]{1,2,3,4});
		qu.print();
	}



	public static class Node{
		Node prev;
		Node next;
		Integer data;

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}
	}

}
