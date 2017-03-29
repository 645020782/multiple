package com.utstar.canceldemo;

public class MyThreadMain {
	public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(2000);
            //thread.interrupt();//请求中断MyThread线程
            thread.cancel();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
	}
}
