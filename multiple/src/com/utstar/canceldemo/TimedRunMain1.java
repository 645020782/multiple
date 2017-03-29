package com.utstar.canceldemo;

import java.util.concurrent.TimeUnit;

public class TimedRunMain1 {
	public static void main(String[] args) {
        TimedRun1 timeRun1 = new TimedRun1();
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
        timeRun1.timedRun(run, 1, TimeUnit.MILLISECONDS);
    }

}
