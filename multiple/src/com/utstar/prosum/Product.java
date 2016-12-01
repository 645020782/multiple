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
		int time = 50;
		String temp = null;
		while(time>0){
			if(list.isFull()){
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			temp = getProduct()+i;
			list.add(temp);
			System.out.println(Thread.currentThread().getName()+","+temp+"������Ѽ:"+list.getCount()+"ֻ");
			i++;
			time--;
		}
	}
	public String getProduct(){
		return "������Ѽ";
	}
}
