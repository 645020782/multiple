package com.utstar.multiple;

public class RunnableNum implements Runnable{
    int count;
	private int num;
	public RunnableNum(int num){
		this.count = 1000;
		this.num = num;
	}
	@Override
	public void run() {
		int i = 0;
			while(count > 0){
				try {
					System.out.println(Thread.currentThread().getName()+",÷¥––¡À"+(i+1)+"¥Œ"+",count:"+count);
					count = discount();
					i++;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}
	public synchronized int discount(){
		return count - num;
	}
}
