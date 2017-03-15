package com.utstar.executordemo;

public class Run {

	public static void main(String[] args) {
		ConcurrentCalculator cal = new ConcurrentCalculator();
		int[] numbers = new int[] {1,2,3,4,5,6,7,8,9,10};
		Long sum = cal.sum(numbers);
		System.out.println(sum);
		cal.close();
	}

}
