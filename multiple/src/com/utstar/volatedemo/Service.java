package com.utstar.volatedemo;

public class Service extends Thread{
	volatile private boolean isContinue = true;
	public void printA(){
		while(isContinue){
		}
		System.out.println("the thread is stop!!");
	}
	public boolean isContinue() {
		return isContinue;
	}
	public void setContinue(boolean isContinue) {
		this.isContinue = isContinue;
	}
	@Override
	public void run() {
		System.out.println("进入run");
		printA();
	}
	
}
