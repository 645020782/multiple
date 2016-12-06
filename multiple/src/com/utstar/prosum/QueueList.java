package com.utstar.prosum;

import java.util.ArrayList;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class QueueList {
	private ArrayList<String> array;
	private Lock lock = new ReentrantLock();
	private Condition c = lock.newCondition();
	private Condition c1 = lock.newCondition();
	public QueueList(){
		array = new ArrayList<String>(100);
	}
	synchronized public boolean isEmpty(){
		boolean i = false;
		if(array.size()==0){
			i = true;
		}
		return i;
	}
	synchronized public boolean isFull(){
		boolean i = false;
		if(array.size()==100){
			i = true;
		}
		return i;
	}
	 public void add(String s){
		lock.lock();
		try{
			while(isFull()){
				c.await();
			 }
			array.add(s);
			System.out.println("共有鸭子:"+getCount()+"只");
			c1.signalAll();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		 
	}
	 public String discount(){
		 lock.lock();
		 String s = null;
			try{
				while(isEmpty()){
					c1.await();
				 }
				s = array.get(getCount()-1);
			array.remove(s);
			c.signalAll();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		return s;
	}
    public int getCount(){
		lock.lock();
		//System.out.println("进入getCount");
		int c = 0;
			try{
				c = array.size();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		return c;
	}
}
