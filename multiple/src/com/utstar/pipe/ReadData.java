package com.utstar.pipe;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReadData {
	public void readMethod(PipedInputStream in){
		byte[] b = new byte[1024];
		try {
			int len = 0;
			while((len=in.read(b))!=-1){
				String inData = new String(b,0,len);
				System.out.println(inData);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
