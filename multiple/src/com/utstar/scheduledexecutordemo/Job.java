package com.utstar.scheduledexecutordemo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Job implements Runnable {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
	
	@Override
    public void run() {  
        try {  
            Thread.sleep(1000);  
        } catch (InterruptedException ex) {  
            ex.printStackTrace();  
        }  
        System.out.println("do something  at:" + sdf.format(new Date()));  
    }  
	
}
