package com.utstar.pipe;

import java.io.PipedInputStream;
import java.io.PipedReader;

public class ReadThreadS extends Thread{
	private ReadDataS readDataS;
	private PipedReader in;
	
	public ReadThreadS(ReadDataS readDataS, PipedReader in) {
		super();
		this.readDataS = readDataS;
		this.in = in;
	}

	@Override
	public void run() {
		readDataS.readMethod(in);
	}

}
