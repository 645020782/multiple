package com.utstar.canceldemo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PrimeGenerator implements Runnable{
	private volatile boolean canceled = false;
	private final List<BigInteger> l = new ArrayList<BigInteger>();
	private volatile BigInteger p = BigInteger.ONE;
	@Override
	public void run() {
		while (!canceled) {
			synchronized (this) {
				p = p.nextProbablePrime();
				l.add(p);
			}
		}
	}
	public void cancel() {
		this.canceled = true;
	}
	public synchronized List<BigInteger> get(){
		return new ArrayList<BigInteger>(l);
	}
}
