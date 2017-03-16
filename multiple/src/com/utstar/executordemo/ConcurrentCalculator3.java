package com.utstar.executordemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ConcurrentCalculator3 {
	private int cupCoreNumber;
	private List<Future<Long>> tasks = new ArrayList<Future<Long>>();
	private ExecutorService exec;
	private CompletionService<Long> cs;
	public ConcurrentCalculator3() {
		this.cupCoreNumber = Runtime.getRuntime().availableProcessors();
		this.exec = Executors.newFixedThreadPool(cupCoreNumber);
		this.cs = new ExecutorCompletionService<Long>(exec);
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
			if (!exec.isShutdown()) {
				cs.submit(cal);
			}
			
		}
		Long result = 0L;
		for (int j = 0; j < cupCoreNumber; j++) {
			try {
				Future<Long> take = cs.take();
				Long sub = take.get();
				result += sub;
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
