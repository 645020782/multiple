package com.utstar.canceldemo;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class PrimeProducer extends Thread{
	private final BlockingQueue<BigInteger> queue;
	public PrimeProducer(BlockingQueue<BigInteger> queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		BigInteger p = BigInteger.ONE;
		while (!Thread.currentThread().isInterrupted()) {
			try {
				queue.put(p = p.nextProbablePrime());
				System.out.println(Thread.currentThread().getName() + "　生产数字 " + p);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println(Thread.currentThread().getName()+"线程已中断");
				System.out.println(Thread.currentThread().isInterrupted());
			}
		}
	}
	public void cancel() {
		interrupt();
	}
}
