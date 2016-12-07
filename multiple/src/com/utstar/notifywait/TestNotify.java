package com.utstar.notifywait;

public class TestNotify {

	public static void main(String[] args) {
		String a = new String("aa");
		ThreadA t1 = new ThreadA(a);
		t1.setName("AA");
		ThreadB t2 = new ThreadB(a);
		t2.setName("BB");
		t2.start();
		t1.start();
	}

}
