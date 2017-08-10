package com.utstar.forkjoindemo;

import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Integer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int threshold = 2;
	private int start;
	private int end;
	public CountTask(int start, int end) {
		this.start = start;
		this.end = end;
	}
	@Override
	protected Integer compute() {
		int sum = 0;
		boolean isComputalbe = (end - start) <= threshold;
		if (isComputalbe) {
			for (int i = start; i < end; i++) {
				sum += i;
			}
		} else {
			// 如果任务大于阈值，就分裂成两个子任务计算
			int middle = (end + start) / 2;
			CountTask leftTask = new CountTask(start, middle);
			CountTask rightTask = new CountTask(middle + 1, end);
			// 执行子任务
            leftTask.fork();
            rightTask.fork();
            //等待任务执行结束合并其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            //合并子任务
            sum = leftResult + rightResult;
		}
		return sum;
	}

}
