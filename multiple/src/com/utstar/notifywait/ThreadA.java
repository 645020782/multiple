package com.utstar.notifywait;

import java.util.ArrayList;
import java.util.List;

public class ThreadA extends Thread{
	private String lock;
	public ThreadA(String lock){
		this.lock = lock;
	}
	@Override
	public void run() {
		synchronized (lock) {
			for(int i=0;i<10;i++){
				if(MyList.size()==5){
					lock.notify();
					System.out.println(ThreadA.currentThread().getName()+"send notify!!");
				}
				MyList.add();
				System.out.println("list added"+(i+1)+"string.");
			}
		}
	}
	
}
