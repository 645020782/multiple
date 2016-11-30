package com.utstar.multiple;

public class ThreadOne extends Thread{
	private Service service;
	public ThreadOne(Service service){
		 this.service = service;
	}
	@Override
	public void run() {
		while(true){
			try {
				service.setName();
				Thread.sleep(800);
				service.getName();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
