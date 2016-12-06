package com.utstar.volatedemo;

public class MyThread extends Thread{
	/*volatile*/ private static int count=0;
	synchronized public static void addCount(){
		for(int i=0;i<100;i++){
			count++;
		}
		System.out.println("count=:"+count);
	}
	@Override
	public void run() {
		addCount();
	}
	
}
