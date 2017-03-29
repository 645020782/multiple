package com.utstar.canceldemo;

import java.io.InterruptedIOException;

public class MyThread extends Thread{

	@SuppressWarnings("static-access")
	@Override
    public void run() {
        super.run();
        try {
        	for (int i = 0; i < 500000; i++) {
                if (this.interrupted()) {
                	System.out.println(Thread.currentThread().isInterrupted());
                    System.out.println("should be stopped and exit");
                    //break;
                    throw new InterruptedException();
                }
                System.out.println("i=" + (i + 1));
            }
            System.out.println("this line is also executed. thread does not stopped");//尽管线程被中断,但并没有结束运行。这行代码还是会被执行
        } catch (InterruptedException e){
        	System.out.println(Thread.currentThread().getName() + "thread interruped");
        	System.out.println(Thread.currentThread().isInterrupted());
        }
        
    }
	
	public void cancel(){
		interrupt();
	}
	
}
