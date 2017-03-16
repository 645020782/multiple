package com.utstar.executordemo;

public class Run2 {

	public static void main(String[] args) {
		ConcurrentCalculator2 cal = new ConcurrentCalculator2();
		int[] numbers = new int[] {1,2,3,4,5,6,7,8,9,10};
		Long sum = cal.aasignTask(numbers);
		System.out.println(sum);
		cal.close();
	}

}
