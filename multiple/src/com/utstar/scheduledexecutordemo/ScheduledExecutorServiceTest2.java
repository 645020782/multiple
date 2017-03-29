package com.utstar.scheduledexecutordemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Lenovo
 *3.scheduleAtFixedRate 
 *scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnitunit)
 *创建并执行一个在给定初始延迟后首次启用的定期操作，后续操作具有给定的周期；也就是将在 initialDelay 后开始执行，
 *然后在initialDelay+period 后执行，接着在 initialDelay + 2 * period 后执行，依此类推。
 *如果任务的执行时间小于period，将会按上述规律执行。否则，则会按 任务的实际执行时间进行周期执行。
 */
public class ScheduledExecutorServiceTest2 {
    public static void main(String[] args) {  
        ScheduledExecutorService schedule = Executors.newScheduledThreadPool(2);  
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
        System.out.println(" begin to do something at:" + sdf.format(new Date()));  
        schedule.scheduleAtFixedRate(new Job(), 1,2, TimeUnit.SECONDS);  
    }
}	
