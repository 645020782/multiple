package com.utstar.canceldemo;

import java.util.concurrent.TimeUnit;

public class TimedRunMain2 {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
        TimedRun2 timeRun = new TimedRun2();
        Runnable run = new Runnable() {

            @Override
            public void run() {
                int i = 0;
                for (int j = 0; j < 100000000; j++) {
                    i++;
                    if (i % 10000000 == 0) {
                        System.out.println(i + "  "+ Thread.currentThread().getName());
                    }
                }
            }
        };
        try {
            timeRun.timedRun(run, 1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
