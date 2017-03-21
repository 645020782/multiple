package com.utstar.canceldemo;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class PrimeProducerMain {
	public static void main(String[] args) {
		BlockingQueue<BigInteger> queue = new ArrayBlockingQueue<BigInteger>(3);
		PrimeProducer p = new PrimeProducer(queue);
		p.start();
		while(true){
            try {
                System.out.println(Thread.currentThread().getName()
                        +"消费数据"+queue.take());// 从队列取出一个数  
                TimeUnit.SECONDS.sleep(1);// 停止1s,显示出消费速度慢于生产速度　
                System.out.println("Thread name : " + Thread.currentThread().getName());
                p.cancel();
                System.out.println(Thread.currentThread().getName() + " : " + Thread.currentThread().isInterrupted());
                //Thread.currentThread().interrupt();// 消费者请求停止生产　
                //System.out.println(Thread.currentThread().getName() + " : " + Thread.currentThread().isInterrupted());
            } catch (InterruptedException e) {
                System.out.println("被中断了");
            } 
        }
	}
}
