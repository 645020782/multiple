package com.utstar.canceldemo;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
/**
 * 
 * 如果生产者的速度超过了消费者的处理速度，队列将被填满，put 方法也会阻塞。当生产者在put 方法中阻塞时，如果消费者希望取消生产者任务，
 * 那么将发生什么情况呢？它可以调用cancel 方法来设置cancelled标志，但此时生产者却永远不能检查这个标志，
 * 因为它无法从阻塞的put 方法中恢复过来（因为消费者此时已经停止从队列中取出素数，所以put方法将一直保持阻塞状态）。
 * @author Lenovo
 *
 */
public class BrokenPrimeProducer_Main {
    public static void main(String[] args){
        BlockingQueue<BigInteger> queue = new ArrayBlockingQueue<>(3);
        BrokenPrimeProducer producer = new BrokenPrimeProducer(queue);
        producer.start();
        while(true){
            try {
                System.out.println(Thread.currentThread().getName()
                        +"消费数据"+queue.take());// 从队列取出一个数  
                TimeUnit.SECONDS.sleep(1);// 停止1s,显示出消费速度慢于生产速度　
                producer.cancel();// 消费者请求停止生产　  
                
            } catch (InterruptedException e) {
                System.out.println("被中断了");
            }
        }
    }
}
