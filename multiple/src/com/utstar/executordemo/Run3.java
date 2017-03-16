package com.utstar.executordemo;

public class Run3 {

	public static void main(String[] args) {
		ConcurrentCalculator3 cal = new ConcurrentCalculator3();
		int[] numbers = new int[] {1,2,3,4,5,6,7,8,9,10};
		Long sum = cal.aasignTask(numbers);
		System.out.println(sum);
		cal.close();
	}

}
