package com.utstar.executordemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ConcurrentCalculator2 {
	private int cupCoreNumber;
	private List<Future<Long>> tasks = new ArrayList<Future<Long>>();
	private ExecutorService exec;
	public ConcurrentCalculator2() {
		this.cupCoreNumber = Runtime.getRuntime().availableProcessors();
		this.exec = Executors.newFixedThreadPool(cupCoreNumber);
	}
	public Long aasignTask(final int[] numbers) {
		
		for (int i = 0; i < cupCoreNumber; i++) {
			int avg = numbers.length / cupCoreNumber +1;
			int start = avg * i;
			int end = start + avg;
			if (end > numbers.length) {
				end = numbers.length;
			}
			Calculator cal = new Calculator(numbers, start, end);
			FutureTask<Long> task = new FutureTask<Long>(cal);
			tasks.add(task);
			if (!exec.isShutdown()) {
				exec.submit(task);
			}
			
		}
		return getResult();
	}
	private Long getResult(){
		Long result = 0L;
		for (Future<Long> task : tasks) {
			try {
				Long subSum = task.get();
				result += subSum;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public void close() {
		exec.shutdown();
	}
}
