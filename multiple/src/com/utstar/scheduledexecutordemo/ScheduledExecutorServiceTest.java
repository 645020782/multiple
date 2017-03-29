package com.utstar.scheduledexecutordemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {
	public static void main(String[] args) {
		ScheduledExecutorService schedule = Executors.newScheduledThreadPool(5);  
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
        System.out.println(" begin to do something at:" + sdf.format(new Date()));  
        schedule.schedule(new Job(),1, TimeUnit.SECONDS);
	}
}	
