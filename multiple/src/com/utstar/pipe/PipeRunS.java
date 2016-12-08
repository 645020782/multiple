package com.utstar.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipeRunS {

	public static void main(String[] args) {
		WriteDataS writeDataS = new WriteDataS();
		PipedWriter out = new PipedWriter();
		ReadDataS readDataS =  new ReadDataS();
		PipedReader in = new PipedReader();
		try {
			out.connect(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WriteThreadS w = new WriteThreadS(writeDataS, out);
		ReadThreadS r = new ReadThreadS(readDataS,in);
		r.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w.start();
	}

}
