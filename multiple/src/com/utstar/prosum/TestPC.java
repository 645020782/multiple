package com.utstar.prosum;

public class TestPC {
	public static void main(String[] args){
		QueueList list = new QueueList();
		Product p = new Product(list);
		//Product p1 = new Product(list);
		Consume c = new Consume(list);
		//Consume c1 = new Consume(list);
		p.setName("PA");
		//p1.setName("PA1");
		c.setName("CB");
		//c1.setName("CB1");
		p.start();
		//p1.start();
		c.start();
		//c1.start();
	}
}
