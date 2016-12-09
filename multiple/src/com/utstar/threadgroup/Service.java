package com.utstar.threadgroup;

public class Service extends Thread{
    private static int addNum=1;
	private String word; 
	private String lock; 
	private int numPartition;
	private int printCount=0;
	
	public Service(String word, int numPartition,String lock) {
		super();
		this.word = word;
		this.lock = lock;
		this.numPartition = numPartition;
	}

	@Override
	public void run() {
		while(true){
			synchronized (lock) {
				while(addNum%3!=numPartition){
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+",timer:"+addNum+",keyWord:"+word);
				lock.notifyAll();
				addNum++;
				printCount++;
				if(printCount==30){
					break;
				}
			}
		}
	}
	
}
