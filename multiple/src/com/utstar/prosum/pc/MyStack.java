package com.utstar.prosum.pc;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
	private List<String> list = new ArrayList<String>();
	synchronized public void push(){
		while(list.size()==1){
			try {
				System.out.println(Thread.currentThread().getName()+"...pushing...,now status is waitting!");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String value = System.currentTimeMillis()+"_"+System.nanoTime();
		list.add(value);
		System.out.println(Thread.currentThread().getName()+",push value :"+value+",stack size:"+list.size());
		notifyAll();
	}
	synchronized public void pop(){
		while(list.size()==0){
			try {
				System.out.println(Thread.currentThread().getName()+"...popping...,now status is waitting!");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String value = list.get(0);
		list.remove(0);
		System.out.println(Thread.currentThread().getName()+",pop value :"+value+",stack size:"+list.size());
		notifyAll();
	}
}
