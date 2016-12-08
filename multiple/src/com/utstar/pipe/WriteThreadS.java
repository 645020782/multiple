package com.utstar.pipe;

import java.io.PipedOutputStream;
import java.io.PipedWriter;

public class WriteThreadS extends Thread{
	private WriteDataS writeDataS;
	private PipedWriter out;
	
	public WriteThreadS(WriteDataS writeDataS, PipedWriter out) {
		super();
		this.writeDataS = writeDataS;
		this.out = out;
	}

	@Override
	public void run() {
		writeDataS.writeMethod(out);
	}
	
}
