package com.utstar.executordemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ConcurrentCalculator {
	private ExecutorService exec;
	private int cupCoreNumber;
	private List<Future<Long>> tasks = new ArrayList<Future<Long>>();
	class SumCalculator implements Callable<Long>{
		private int start;  
		private int end;
		private int[] numbers;
		public SumCalculator(final int[] numbers, int start, int end) {
			this.numbers = numbers;
			this.start = start;
			this.end = end;
		}
		@Override
		public Long call() throws Exception {
			Long sum = 0L;
			for (int i = start; i < end; i++) {
				sum += numbers[i];
			}
			return sum;
		}
	}
	public ConcurrentCalculator(){
		this.cupCoreNumber = Runtime.getRuntime().availableProcessors();
		this.exec = Executors.newFixedThreadPool(cupCoreNumber);
	}
	public Long sum(final int[] numbers) {
		for (int i = 0; i < cupCoreNumber; i++) {
			int avg = numbers.length / cupCoreNumber + 1;
			int start = avg * i;
			int end = start + avg;
			if (end > numbers.length) {
				end = numbers.length;
			}
			SumCalculator sumCalculator = new SumCalculator(numbers, start, end);
			FutureTask<Long> task = new FutureTask<Long>(sumCalculator);
			tasks.add(task);
			if (!exec.isShutdown()) {
				exec.submit(task);
			}
		}
		return getResult();
	}
	public Long getResult(){
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
