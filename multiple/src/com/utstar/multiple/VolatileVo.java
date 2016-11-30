package com.utstar.multiple;

public class VolatileVo extends Thread{
	private volatile int count;
	public VolatileVo(int i){
		this.count = i;
	}
	@Override
	public void run() {
		while(true){
			getCount();
		}
	}
	public void getCount(){
		synchronized(this){
			count ++;
			System.out.println(Thread.currentThread().getName()+"-count:"+count);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
