package com.utstar.canceldemo;

public class AlternateStopMain {
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
