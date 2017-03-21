package com.utstar.canceldemo;

public class InterruptCheck {
	public static void main(String[] args) {
		Thread t=Thread.currentThread();
		System.out.println("A: isInterrupted="+t.isInterrupted());
		t.interrupt();
		System.out.println("B: isInterrupted="+t.isInterrupted());
		System.out.println("C: isInterrupted="+t.isInterrupted());
		try {
		Thread.sleep(2000);
		System.out.println("线程没有被中断");
		}
		catch(InterruptedException x) {
		System.out.println("线程被中断了");
		}
		System.out.println("D: isInterrupted="+t.isInterrupted());
		}
}
