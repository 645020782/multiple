package com.utstar.canceldemo;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Lenovo
 * 定时中断程序，程序中的顺序是先启动线程任务，再启动定时器，因为定时器与Thread.join(long timeout)是相同时间，所以
 * 能够保证Thread运行timeout后再被中断,即即使定时器失效，join(timeout)也会出现超时。
 */
public class TimedRun2 {
	 private static final ScheduledExecutorService cancelExec = Executors
	            .newScheduledThreadPool(1);

	    public static void timedRun(final Runnable r, long timeout, TimeUnit unit)
	            throws InterruptedException {
	        class RethrowableTask implements Runnable {
	            private volatile Throwable t;

	            public void run() {
	                try {
	                    r.run();
	                } catch (Throwable t) {
	                    this.t = t;
	                }
	            }

	            void rethrow() {
	                if (t != null)
	                    try {
	                        throw launderThrowable(t);
	                    } catch (Exception e) {
	                        e.printStackTrace();
	                    }
	            }
	        }

	        RethrowableTask task = new RethrowableTask();
	        final Thread taskThread = new Thread(task);
	        taskThread.start();
	        cancelExec.schedule(new Runnable() {
	            public void run() {
	            	System.out.println("srun time" + System.currentTimeMillis());
	                taskThread.interrupt();
	                System.out.println("1--" + taskThread.isInterrupted());
	            }
	        }, timeout, unit);
	        System.out.println("join begin time" + System.currentTimeMillis());
	        taskThread.join(unit.toMillis(timeout));
	        System.out.println("join end time" + System.currentTimeMillis());
	        task.rethrow();
	        System.out.println("2--" + taskThread.isInterrupted());
	    }

	    public static Exception launderThrowable(Throwable t) {
	        if (t instanceof RuntimeException)
	            return (RuntimeException) t;
	        else if (t instanceof Error)
	            throw (Error) t;
	        else
	            throw new IllegalStateException("Not unchecked", t);
	    }

}
