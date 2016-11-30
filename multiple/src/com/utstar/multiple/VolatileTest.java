package com.utstar.multiple;

public class VolatileTest {
	public static void main(String[] args){
		int a = 1;
		VolatileVo v1 = new VolatileVo(a);
		Thread t1 = new Thread(v1);
		Thread t2 = new Thread(v1);
		Thread t3 = new Thread(v1);
		t1.start();
		t2.start();
		t3.start();
	}
}
