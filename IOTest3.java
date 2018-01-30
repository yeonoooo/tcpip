package com.multi.day19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest3 {
	public static void main(String[] args) throws IOException {
		/*FileOutputStream fo = new FileOutputStream("data.txt");
		
		fo.write(64);
		fo.write(13);
		byte[] arr = {63,64,65,66,67,68,69}; // 이미지는 byte로 읽음.
		fo.write(arr);
		fo.close();
		*/
		
		FileInputStream fi = null;
		FileOutputStream fo = null;
		int data;
		
		fi = new FileInputStream("lovely.jpg");
		fo = new FileOutputStream("lovely2.jpg");
		
		while(true) {
			data = fi.read();
			if(data ==-1) break;
			fo.write(data);
		}
		
		fi.close();
		fo.close();
	}
}
