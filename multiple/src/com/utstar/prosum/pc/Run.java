package com.utstar.prosum.pc;

public class Run {
	public static void main(String[] args){
		MyStack myStack = new MyStack();
		P p = new P(myStack);
		C c = new C(myStack);
		ThreadP t1 = new ThreadP(p);
		ThreadP t5 = new ThreadP(p);
		ThreadP t6 = new ThreadP(p);
		ThreadC t2 = new ThreadC(c);
		ThreadC t3 = new ThreadC(c);
		ThreadC t4 = new ThreadC(c);
		t1.start();
		t5.start();
		t6.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
