package com.utstar.canceldemo;

import java.util.concurrent.TimeUnit;

public class TimedRunMain3 {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
        TimedRun3 timeRun = new TimedRun3();
        Runnable run = new Runnable() {

            @Override
            public void run() {
                int i = 0;
                while (!Thread.currentThread().isInterrupted()) {
                	System.out.println(Thread.currentThread().getName() + " : " 
        					+ Thread.currentThread().isInterrupted());
                	for (int j = 0; j < 100000000; j++) {
                        i++;
                        if (i % 10000000 == 0) {
                            System.out.println(i + "  "+ Thread.currentThread().getName());
                        }
                    }
                }
            }
        };
        try {
            timeRun.timedRun(run, 200, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
