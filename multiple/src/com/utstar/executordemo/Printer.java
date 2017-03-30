package com.utstar.executordemo;

import java.util.concurrent.Callable;

public class Printer implements Callable<String>{
	private String ps;
	private int cycleTime;
	public Printer(String ps, int cycleTime) {
		this.ps = ps;
		this.cycleTime = cycleTime;
	}
	@Override
	public String call() throws Exception {
		while (cycleTime > 0) {
			System.out.print(ps);
			cycleTime--;
		}
		return null;
	}

}
