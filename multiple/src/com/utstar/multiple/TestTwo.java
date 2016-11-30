package com.utstar.multiple;

public class TestTwo {
	public static void main(String[] args){
		int num = 10;
		RunnableNum r = new RunnableNum(num);
		Thread t1 = new Thread(r,"A");
		Thread t2 = new Thread(r,"B");
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
			Thread.sleep(1000);
			Thread.yield();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end !!!!"+r.count);
	}
}
