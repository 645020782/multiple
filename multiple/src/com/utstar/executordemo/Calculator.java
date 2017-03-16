package com.utstar.executordemo;

import java.util.concurrent.Callable;

public class Calculator implements Callable<Long>{
	private int[] numbers;
	private int start;
	private int end;
	public Calculator(final int[] numbers, int start, int end){
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}
	@Override
	public Long call() throws Exception {
		Long result = 0L;
		for (int i = start; i < end; i++) {
			result += numbers[i];
		}
		return result;
	}

}
