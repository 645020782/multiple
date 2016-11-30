package com.utstar.multiple;

public class TestOne {

	public static void main(String[] args) {
		Service s = new Service();
		ThreadOne t1 = new ThreadOne(s);
		t1.setName("A");
		ThreadOne t2 = new ThreadOne(s);
		t2.setName("B");
		t1.start();
		t2.start();
	}

}
