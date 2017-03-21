package com.utstar.scheduledexecutordemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Lenovo
 *	2.scheduleWithFixedDelay 
 *scheduleWithFixedDelay(Runnable command, long initialDelay, long delay,TimeUnit unit) 
 *创建并执行一个在给定初始延迟后首次启用的定期操作，随后，在每一次执行终止和下一次执行开始之间都存在给定的延迟，
 *如果任务的执行时间超过了廷迟时间（delay），下一个任务则会在（当前任务执行所需时间+delay）后执行。
 */
public class ScheduledExecutorServiceTest1 {
    public static void main(String[] args) {  
        ScheduledExecutorService schedule = Executors.newScheduledThreadPool(5);  
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
        System.out.println(" begin to do something at:" + sdf.format(new Date()));  
        schedule.scheduleWithFixedDelay(new Job(), 5, 2, TimeUnit.SECONDS);  
    }
}	
