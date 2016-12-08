package com.utstar.pipe;

import java.io.PipedInputStream;

public class ReadThread extends Thread{
	private ReadData readData;
	private PipedInputStream in;
	
	public ReadThread(ReadData readData, PipedInputStream in) {
		super();
		this.readData = readData;
		this.in = in;
	}

	@Override
	public void run() {
		readData.readMethod(in);
	}

}
