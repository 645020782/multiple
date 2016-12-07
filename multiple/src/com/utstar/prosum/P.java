package com.utstar.prosum;

public class P {
	private String lock;
	public P(String lock){
		this.lock = lock;
	}
	 public void setValue(){
		synchronized(lock){
			while(!ValueObject.value.equals("")){
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			String value = System.currentTimeMillis()+"_"+System.nanoTime();
			System.out.println(Thread.currentThread().getName()+",set value:"+value);
			ValueObject.setValue(value);
			lock.notify();
		}
	}
}
