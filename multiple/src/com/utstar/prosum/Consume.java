package com.utstar.prosum;

public class Consume extends Thread{
	private QueueList list;
	public Consume(QueueList list){
		this.list = list;
	}
	@Override
	public void run() {
		String temp = null;
		int time = 50;
		while(time>0){
			if(list.isEmpty()){
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			temp = list.discount();
			time--;
			System.out.println(Thread.currentThread().getName()+",消费烧鸭:"+temp+",还剩烧鸭:"+list.getCount()+"只");
		}
	}
	
}
