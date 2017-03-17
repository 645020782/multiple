package com.utstar.canceldemo;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * 7.3 不可靠的取消操作将把生产者置于阻塞的操作中
 * @ClassName: BrokenPrimeProducer
 * @date 2014-9-30 上午9:55:56
 */
public class BrokenPrimeProducer extends Thread{
    
    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled = false;
    
    public BrokenPrimeProducer(BlockingQueue<BigInteger> queue){
        this.queue = queue;
    }

    public void run(){
        BigInteger p = BigInteger.ONE;
        while(!cancelled){
            try {
                queue.put(p= p.nextProbablePrime());
                System.out.println(Thread.currentThread().getName()+"生产数字："+p);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+"线程中断");
            }            
        }
    }
    
    public void cancel(){
        this.cancelled = true;
    }
}