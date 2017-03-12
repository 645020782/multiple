package com.utstar.threadgroup;

public class Run {
	public static void main(String[] args){
		String lock = new String("a");
		Service t1 = new Service("A", 1,lock);
		Service t2 = new Service("B", 2,lock);
		Service t3 = new Service("C", 0,lock);
		t1.start();
		t2.start();
		t3.start();
	}
}
