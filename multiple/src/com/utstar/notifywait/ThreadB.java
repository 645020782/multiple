package com.utstar.notifywait;

import java.util.ArrayList;
import java.util.List;

public class ThreadB extends Thread{
	private String lock;
	public ThreadB(String lock){
		this.lock = lock;
	}
	@Override
	public void run() {
		synchronized (lock) {
			if(MyList.size()!=5){
				try {
					System.out.println(ThreadA.currentThread().getName()+"begin wait!!");
					lock.wait();
					System.out.println(ThreadA.currentThread().getName()+"end wait");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
