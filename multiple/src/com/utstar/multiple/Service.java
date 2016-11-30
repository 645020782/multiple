package com.utstar.multiple;

import java.util.Random;

public class Service {
	private volatile String name;
	public Service(){
		this.name = newName();
	}
	public void setName(){
		name = newName();
		System.out.println(Thread.currentThread().getName()+",set the newName:"+name);
	}
	public void getName(){
		System.out.println(Thread.currentThread().getName()+",get the newName:"+name);
	}
	public String newName(){
		String name = "YANG";
		Random r = new Random();
		int n = r.nextInt(10);
		String t = name + n;
		return t;
	}
}
