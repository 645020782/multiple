package com.utstar.prosum.pc;

public class C {
	private MyStack myStack;
	public C(MyStack myStack){
		this.myStack = myStack;
	}
	public void getValue(){
		myStack.pop();
	}
}
