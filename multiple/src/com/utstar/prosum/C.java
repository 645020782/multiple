package com.utstar.prosum;

public class C {
	private String lock;
	public C(String lock){
		this.lock = lock;
	}
	public void getValue(){
		synchronized(lock){
			while(ValueObject.value.equals("")){
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+",the value:"+ValueObject.value);
			ValueObject.setValue("");
			lock.notify();
		}
	}
}
