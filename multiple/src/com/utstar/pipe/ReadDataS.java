package com.utstar.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedReader;

public class ReadDataS {
	public void readMethod(PipedReader in){
		char[] b = new char[1024];
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
