package com.utstar.threadgroup;

public class GroupTest {
	public static void main(String[] args){
		ThreadGroup group = new ThreadGroup("test group");
		ThreadA a = new ThreadA();
		ThreadB b = new ThreadB();
		Thread t1 = new Thread(group,a);
		Thread t2 = new Thread(group,b);
		t1.start();
		t2.start();
		System.out.println("活动线程数:"+group.activeCount());
		System.out.println("线程组名:"+group.getName());
	}
}
