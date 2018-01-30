package com.multi.day19;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// reader = 2byte(한글)
// stream = 1byte
public class IOTest {
	public static void method1() {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("src/com/multi/day19/EnumTest.java"); // 2byte(8bit)씩 읽음
			fw = new FileWriter("EnumTest.java"); // 경로 주지않음 >> 확인해보기 위해
			System.out.println("There is the file. File opend.");
			System.out.println("You can read the file.");

			int data = 0; // file byte size 알고 싶을 때 사용하면 됨
			//방법 1
			char[] cBuf = new char[1790];
			fr.read(cBuf);
			System.out.println(cBuf);
			fw.write(cBuf);
			//방법2
			/*
			 * while((data = fr.read())!=-1){ //EOF =-1 System.out.print((char)data); }
			 */
			//방법3
			/*
			 * while (true) { if(data == -1) break; System.out.print((char) data); }
			 */
			System.out.println("END");
		} catch (FileNotFoundException e) {
			System.out.println("There is no file.");
		} catch (IOException e) {
			System.out.println("File cannot be read.");
		} finally {
			try {
				if (fr != null)
					fr.close(); // open시 예외/에러 발생 가능. 초기화 해야함.
				System.out.println("File closed.");
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		method1();
	}
}
