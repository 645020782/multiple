package com.utstar.canceldemo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimedRun1 {
	private static final ScheduledExecutorService cancelExec = Executors.newScheduledThreadPool(1);

    public static void timedRun(Runnable r,long timeout, TimeUnit unit) {
        final Thread taskThread = Thread.currentThread();
        cancelExec.schedule(new Runnable() {
            public void run() {
                taskThread.interrupt();
                System.out.println("1--"+taskThread.isInterrupted());                
            }
        }, timeout, unit);
        r.run();
        System.out.println("2--"+taskThread.isInterrupted());  
    }

}
