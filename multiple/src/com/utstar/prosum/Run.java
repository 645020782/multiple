package com.utstar.prosum;

public class Run {
	public static void main(String[] args){
		String lock = new String("a");
		P p = new P(lock);
		C c = new C(lock);
		ThreadP t1 = new ThreadP(p);
		ThreadC t2 = new ThreadC(c);
		t1.start();
		t2.start();
	}
}
