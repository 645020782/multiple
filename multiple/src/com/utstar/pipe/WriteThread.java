package com.utstar.pipe;

import java.io.PipedOutputStream;

public class WriteThread extends Thread{
	private WriteData writeData;
	private PipedOutputStream out;
	
	public WriteThread(WriteData writeData, PipedOutputStream out) {
		super();
		this.writeData = writeData;
		this.out = out;
	}

	@Override
	public void run() {
		writeData.writeMethod(out);
	}
	
}
