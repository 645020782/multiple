package com.utstar.volatedemo;

public class MyRun {

	public static void main(String[] args) {
		MyThread[] array = new MyThread[100];
		for(int i = 0;i<100;i++){
			 array[i] = new MyThread();
		}
		for(int j=0;j<100;j++){
			array[j].start();
		}
	}

}
