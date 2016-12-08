package com.utstar.pipe;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteData {
	public void writeMethod(PipedOutputStream out){
		for(int i=0;i<20;i++){
			String outData = ""+(i+1);
			byte[] b= outData.getBytes();
			try {
				out.write(b);
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
