package com.utstar.prosum;

import java.util.ArrayList;
import java.util.List;

public class Product extends Thread{
	private QueueList list;
	public Product(QueueList list){
		this.list = list;
	}
	@Override
	public void run() {
		int i = 0;
		int time = 10;
		String temp = null;
		while(time>0){
			if(list.isFull()){
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			temp = getProduct()+(i+1);
			System.out.println(Thread.currentThread().getName()+","+temp);
			list.add(temp);
			i++;
			time--;
		}
	}
	public String getProduct(){
		return "Éú²úÉÕÑ¼";
	}
}
