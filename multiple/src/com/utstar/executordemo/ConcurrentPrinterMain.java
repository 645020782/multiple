package com.utstar.executordemo;

public class ConcurrentPrinterMain {
	public static void main(String[] args) {
		ConcurrentPrinter c = new ConcurrentPrinter(4, "ABC");
		c.assignTask(100);
		c.close();
	}
}
