package com.utstar.canceldemo;

public class AlternateStop implements Runnable {
	private volatile boolean stopRequested;  
    private Thread runThread;  
  
    public void run() {  
        runThread = Thread.currentThread();  
        stopRequested = false;  
        int count = 0;  
        while (!stopRequested) {  
            System.out.println("Running ... count=" + count);  
            count++;  
            try {  
                Thread.sleep(300);  
            } catch (InterruptedException x) {  
                System.out.println("捕获异常后---"+Thread.currentThread().isInterrupted());  
                Thread.currentThread().interrupt(); // re-assert interrupt  
                System.out.println("重新设置打断状态---"+Thread.currentThread().isInterrupted());  
            }  
        }  
  
        System.out.println("stoped");  
    }  
  
    public void stopRequest() {  
        stopRequested = true;  
        if (runThread != null) {  
            runThread.interrupt();  
        }  
    }  
  
    public static void main(String[] args) {  
        AlternateStop as = new AlternateStop();  
        Thread t = new Thread(as);  
        t.start();  
        try {  
            Thread.sleep(2000);  
        } catch (InterruptedException x) {  
            // ignore  
        }  
        as.stopRequest();  
    }  
}
