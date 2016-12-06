package com.utstar.volatedemo;

public class VolatileTest {

	public static void main(String[] args) throws Exception {
		Service service = new Service();
		service.start();
		Thread.sleep(1000);
		service.setContinue(false);
		System.out.println("continue 被赋值为false");
	}

}
