package com.utstar.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeRun {

	public static void main(String[] args) {
		WriteData writeData = new WriteData();
		PipedOutputStream out = new PipedOutputStream();
		ReadData readData =  new ReadData();
		PipedInputStream in = new PipedInputStream();
		try {
			out.connect(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WriteThread w = new WriteThread(writeData, out);
		ReadThread r = new ReadThread(readData,in);
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
