package com.utstar.pipe;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PipedWriter;

public class WriteDataS {
	public void writeMethod(PipedWriter out){
		for(int i=0;i<20;i++){
			String outData = ""+(i+1);
			try {
				out.write(outData);
				System.out.println(outData);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
