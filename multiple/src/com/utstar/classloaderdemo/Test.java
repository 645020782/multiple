package com.utstar.classloaderdemo;

public class Test {
	public void hello() {
		System.out.println("恩，是的，我是由 " + getClass().getClassLoader()
                + " 加载进来的");
	}
}
