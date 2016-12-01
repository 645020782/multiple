package com.utstar.multiple;

public class RunnableNum implements Runnable{
    private int count;
	private int num;
	public RunnableNum(int num){
		this.count = 10000;
		this.num = num;
	}
	@Override
	public void run() {
		int i = 0;
			while(count > 0){
				try {
					//test
					count = discount();
					System.out.println(Thread.currentThread().getName()+",Ö´ÐÐÁË"+(i+1)+"´Î"+",count:"+count);
					i++;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}
	synchronized public int discount(){
		return count - num;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
