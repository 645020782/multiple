package com.utstar.canceldemo;

import java.math.BigInteger;
import java.util.List;

public class Run {
	public static void main(String[] args){
		PrimeGenerator p = new PrimeGenerator();
		new Thread(p).start();
		new Thread(p).start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			p.cancel();
		}
		List<BigInteger> list = p.get();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
