package com.utstar.executordemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ConcurrentPrinter {
	private ExecutorService exec;
	private int nums;
	private String s;
	public ConcurrentPrinter(int nums, String s) {
		this.nums = nums;
		this.s = s;
		this.exec = Executors.newFixedThreadPool(nums);
	}
	public void assignTask(int cycleTime) {
		for (int i = 0; i < s.length(); i++) {
			Printer printer = new Printer(s.charAt(i)+"", cycleTime);
			FutureTask<String> task = new FutureTask<String>(printer);
			exec.submit(task);
		}
	}
	public void close() {
		exec.shutdown();
	}
}
