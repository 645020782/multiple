package com.utstar.threadgroup;

public class ThreadA extends Thread{

	@Override
	public void run() {
		while(true){
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
